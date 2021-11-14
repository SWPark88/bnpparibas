package com.bnpparibas.codingTest.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bnpparibas.codingTest.dto.UserDTO;
import com.bnpparibas.codingTest.dto.base.BaseDTO;
import com.bnpparibas.codingTest.dto.base.ErrorDTO;
import com.bnpparibas.codingTest.repository.UserRepository;
import com.bnpparibas.codingTest.utility.BcryptPassEncoder;

@Service
public class UserServiceImp implements UserService {

	private final UserRepository dao;

	private final BcryptPassEncoder bcryptPassEncoder;

	@Autowired
	public UserServiceImp(UserRepository dao, BcryptPassEncoder bcryptPassEncoder) {
		this.dao = dao;
		this.bcryptPassEncoder = bcryptPassEncoder;
	}

	@Override
	public BaseDTO saveUser(UserDTO req) {
		try {
			String encodedPwd = bcryptPassEncoder.encode(req.getPassword());
			req.setPassword(encodedPwd);
			return dao.save(req);
		} catch (IllegalArgumentException e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.BAD_REQUEST, "signup001", "signup fail");
		} catch (Exception e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, "signup002", "signup fail");
		}
	}

	@Override
	public BaseDTO getUser(UserDTO req) {
		try {
			UserDTO entity = dao.findById(req.getId()).get();
			boolean isMatched = bcryptPassEncoder.matches(req.getPassword(), entity.getPassword());
			return isMatched ? entity : new ErrorDTO(HttpStatus.BAD_REQUEST, "login001", "login fail");
		} catch (EntityNotFoundException e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.NOT_FOUND, "login001", "login fail");
		} catch (Exception e) {
			System.err.println(e.toString());
			return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, "login002", "login fail");
		}
	}
}
