package com.bnpparibas.codingTest.service;

import com.bnpparibas.codingTest.dto.UserDTO;
import com.bnpparibas.codingTest.dto.base.BaseDTO;

public interface UserService {
	public BaseDTO getUser(UserDTO entity);

	public BaseDTO saveUser(UserDTO entity);
}
