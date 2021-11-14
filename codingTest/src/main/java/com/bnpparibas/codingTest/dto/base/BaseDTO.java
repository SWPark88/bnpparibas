package com.bnpparibas.codingTest.dto.base;

import org.springframework.http.HttpStatus;

public abstract class BaseDTO {
	public HttpStatus status = HttpStatus.OK;
}
