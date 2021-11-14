package com.bnpparibas.codingTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bnpparibas.codingTest.dto.HistoryDTO;

@Repository
public interface BookRepository extends JpaRepository<HistoryDTO, Integer> {
	@Query("select h from HistoryDTO h where h.id = :id and h.title = :title")
	HistoryDTO findByIdAndTitle(@Param("id") String id, @Param("title") String title);

	@Query("select h from HistoryDTO h where h.id = :id order by h.time")
	List<HistoryDTO> findById(@Param("id") String id);
}
