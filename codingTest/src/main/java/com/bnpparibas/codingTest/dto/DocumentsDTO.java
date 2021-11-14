package com.bnpparibas.codingTest.dto;

import java.util.List;

public class DocumentsDTO {
	// 도서 제목
	private String title;
	// 도서 표지 미리보기 URL
	private String thumbnail;
	// 도서 소개
	private String contents;
	// ISBN10(10자리) 또는 ISBN13(13자리) 형식의 국제 표준 도서번호(International Standard Book
	// Number)
	// ISBN10 또는 ISBN13 중 하나 이상 포함
	// 두 값이 모두 제공될 경우 공백(' ')으로 구분
	private String isbn;
	// 도서 저자 리스트
	private List<String> authors;
	// 도서 출판사
	private String publisher;
	// 도서 출판날짜, ISO 8601 형식
	// [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
	private String datetime;
	// 도서 정가
	private int price;
	// 도서 판매가
	private int sale_price;
	// 도서 판매 상태 정보 (정상, 품절, 절판 등)
	private String status;
	// 도서 번역자 리스트
	private List<String> translators;
	// 도서 상세 URL
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getTranslators() {
		return translators;
	}

	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
