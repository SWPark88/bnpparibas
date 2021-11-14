package com.bnpparibas.codingTest.dto;

import java.util.List;

import com.bnpparibas.codingTest.dto.base.BaseDTO;

public class BookDTO extends BaseDTO {
	private MetaDTO meta;
	private List<DocumentsDTO> documents;

	public MetaDTO getMeta() {
		return meta;
	}

	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}

	public List<DocumentsDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentsDTO> documents) {
		this.documents = documents;
	}
}
