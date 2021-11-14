package com.bnpparibas.codingTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bnpparibas.codingTest.dto.BookSearchDTO;
import com.bnpparibas.codingTest.dto.base.BaseDTO;
import com.bnpparibas.codingTest.service.BookService;

@Controller
@CrossOrigin(origins = { "http://localhost:3000" })
public class BookController {
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/api/searchbook")
	public ResponseEntity<?> searchBook(@RequestBody BookSearchDTO req) {
		BaseDTO res = bookService.getBook(req);
		return ResponseEntity.ok(res);
	}

	@GetMapping("/api/history")
	public ResponseEntity<?> history(@RequestParam String id) {
		BaseDTO res = bookService.getHistory(id);
		return ResponseEntity.ok(res);
	}
}
