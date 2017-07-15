package com.aricent.cop.webengers.models;

public class RequestBody {
	private String jiraName;	
	private String jiraPriority;
	private String jiraSeverity;
	
	public String getJiraName() {
		return jiraName;
	}
	public void setJiraName(String jiraName) {
		this.jiraName = jiraName;
	}
	public String getJiraPriority() {
		return jiraPriority;
	}
	public void setJiraPriority(String jiraPriority) {
		this.jiraPriority = jiraPriority;
	}
	public String getJiraSeverity() {
		return jiraSeverity;
	}
	public void setJiraSeverity(String jiraSeverity) {
		this.jiraSeverity = jiraSeverity;
	}

}
