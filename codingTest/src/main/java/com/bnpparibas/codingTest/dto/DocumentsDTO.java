package com.bnpparibas.codingTest.dto;

import java.util.List;

public class DocumentsDTO {
	// ���� ����
	private String title;
	// ���� ǥ�� �̸����� URL
	private String thumbnail;
	// ���� �Ұ�
	private String contents;
	// ISBN10(10�ڸ�) �Ǵ� ISBN13(13�ڸ�) ������ ���� ǥ�� ������ȣ(International Standard Book
	// Number)
	// ISBN10 �Ǵ� ISBN13 �� �ϳ� �̻� ����
	// �� ���� ��� ������ ��� ����(' ')���� ����
	private String isbn;
	// ���� ���� ����Ʈ
	private List<String> authors;
	// ���� ���ǻ�
	private String publisher;
	// ���� ���ǳ�¥, ISO 8601 ����
	// [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
	private String datetime;
	// ���� ����
	private int price;
	// ���� �ǸŰ�
	private int sale_price;
	// ���� �Ǹ� ���� ���� (����, ǰ��, ���� ��)
	private String status;
	// ���� ������ ����Ʈ
	private List<String> translators;
	// ���� �� URL
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getTranslators() {
		return translators;
	}

	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
