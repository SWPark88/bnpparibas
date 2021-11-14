package com.bnpparibas.codingTest.service;

import com.bnpparibas.codingTest.dto.BookSearchDTO;
import com.bnpparibas.codingTest.dto.base.BaseDTO;

public interface BookService {
	public BaseDTO getBook(BookSearchDTO req);

	public BaseDTO getHistory(String id);
}
