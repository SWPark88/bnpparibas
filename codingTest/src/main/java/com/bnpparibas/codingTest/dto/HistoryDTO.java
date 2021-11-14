package com.bnpparibas.codingTest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class HistoryDTO {
	@Id
	@GeneratedValue
	private Integer seq;
	@Column(nullable = false)
	private String id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String time;
	@Column(nullable = false)
	private Integer count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
