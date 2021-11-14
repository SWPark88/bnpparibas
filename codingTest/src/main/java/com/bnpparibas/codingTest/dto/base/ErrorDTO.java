package com.bnpparibas.codingTest.dto.base;

import org.springframework.http.HttpStatus;

public class ErrorDTO extends BaseDTO {
	private String id;
	private String message;

	public ErrorDTO(HttpStatus status, String id, String message) {
		super();
		this.id = id;
		this.message = message;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
