package com.bnpparibas.codingTest.dto;

import java.util.List;

import com.bnpparibas.codingTest.dto.base.BaseDTO;

public class HistoryListDTO extends BaseDTO {
	private List<HistoryDTO> history;
	private List<FavoriteDTO> favorite;

	public List<HistoryDTO> getHistory() {
		return history;
	}

	public void setHistory(List<HistoryDTO> history) {
		this.history = history;
	}

	public List<FavoriteDTO> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<FavoriteDTO> favorite) {
		this.favorite = favorite;
	}
}
