package com.bnpparibas.codingTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bnpparibas.codingTest.dto.UserDTO;
import com.bnpparibas.codingTest.dto.base.BaseDTO;
import com.bnpparibas.codingTest.service.UserService;

@Controller
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/api/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDTO req) {
		BaseDTO res = userService.saveUser(req);
		return ResponseEntity.status(res.status).body(res);
	}

	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody UserDTO req) {
		BaseDTO res = userService.getUser(req);
		return ResponseEntity.status(res.status).body(res);
	}

}
