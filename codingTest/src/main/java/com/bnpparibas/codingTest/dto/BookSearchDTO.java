package com.bnpparibas.codingTest.dto;

import com.bnpparibas.codingTest.dto.base.BaseDTO;

public class BookSearchDTO extends BaseDTO {
	private String id;
	private String searchTitle;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}
}
