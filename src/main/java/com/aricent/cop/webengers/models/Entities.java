package com.aricent.cop.webengers.models;

import java.util.List;

public class Entities {
	private String name;
	private String prompt;
	private List<Entries> entries;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public List<Entries> getEntries() {
		return entries;
	}
	public void setEntries(List<Entries> entries) {
		this.entries = entries;
	}
}
