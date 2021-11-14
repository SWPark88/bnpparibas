package com.bnpparibas.codingTest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.bnpparibas.codingTest.dto.BookDTO;
import com.bnpparibas.codingTest.dto.BookSearchDTO;
import com.bnpparibas.codingTest.dto.FavoriteDTO;
import com.bnpparibas.codingTest.dto.HistoryDTO;
import com.bnpparibas.codingTest.dto.HistoryListDTO;
import com.bnpparibas.codingTest.dto.base.BaseDTO;
import com.bnpparibas.codingTest.dto.base.ErrorDTO;
import com.bnpparibas.codingTest.repository.BookRepository;

@Service
public class BookServiceImp implements BookService {

	private final BookRepository dao;

	private final RestOperations restOperations;

	@Autowired
	public BookServiceImp(BookRepository dao, RestOperations restOperations) {
		this.dao = dao;
		this.restOperations = restOperations;
	}

	@Override
	public BaseDTO getBook(BookSearchDTO req) {
		try {
			String url = "https://dapi.kakao.com/v3/search/book?query=" + req.getSearchTitle();
			String apiKey = "4c96986f78884051fbe817ed737fabde";
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "KakaoAK " + apiKey);
			HttpEntity<String> request = new HttpEntity<String>(headers);
			ResponseEntity<BookDTO> response = restOperations.exchange(url, HttpMethod.GET, request, BookDTO.class);
			BookDTO result = response.getBody();
			HistoryDTO history = dao.findByIdAndTitle(req.getId(), req.getSearchTitle());
			if (history != null) {
				history.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				history.setCount(history.getCount() + 1);
				dao.save(history);
			} else {
				history = new HistoryDTO();
				history.setId(req.getId());
				history.setTitle(req.getSearchTitle());
				history.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				history.setCount(1);
				dao.save(history);
			}
			return result;
		} catch (EntityNotFoundException e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.NOT_FOUND, "login001", "login fail");
		} catch (Exception e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, "login002", "login fail");
		}
	}

	@Override
	public BaseDTO getHistory(String id) {
		try {
			List<HistoryDTO> historyList = dao.findById(id);
			HistoryListDTO result = new HistoryListDTO();
			result.setHistory(historyList);
			Map<String, List<HistoryDTO>> map = historyList.stream().collect(Collectors.groupingBy(h -> h.getTitle()));
			List<FavoriteDTO> favoriteList = new ArrayList<FavoriteDTO>();
			for (Map.Entry<String, List<HistoryDTO>> _map : map.entrySet()) {
				FavoriteDTO favorite = new FavoriteDTO();
				favorite.title = _map.getKey();
				favorite.count = _map.getValue().stream().mapToInt(r -> r.getCount()).sum();
				favoriteList.add(favorite);
			}
			favoriteList = favoriteList.stream().sorted(Comparator.comparing(FavoriteDTO::getCount).reversed()).limit(10).collect(Collectors.toList());
			result.setFavorite(favoriteList);
			return result;
		} catch (EntityNotFoundException e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.NOT_FOUND, "login001", "login fail");
		} catch (Exception e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, "login002", "login fail");
		}
	}
}
