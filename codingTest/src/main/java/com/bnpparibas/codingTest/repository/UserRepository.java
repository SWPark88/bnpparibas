package com.bnpparibas.codingTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.codingTest.dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String> {
}
