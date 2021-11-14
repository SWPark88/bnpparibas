package com.bnpparibas.codingTest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bnpparibas.codingTest.dto.base.BaseDTO;

import lombok.Data;

@Entity
@Table
@Data
public class UserDTO extends BaseDTO {
	@Id
	@Column(nullable = false)
	private String id;
	@Column(nullable = false)
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
