package com.aricent.cop.webengers.models;

import java.util.List;

public class Entries {
	private String value;
	private List<String> synonyms;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

}
