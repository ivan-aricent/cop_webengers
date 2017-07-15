package com.aricent.cop.webengers.models;

import java.util.List;

public class ServiceDump {
	
	private String name;
	private List<String> templates;
	private String url;
	private String auth;
	private List<Entities> entities;
	private String requestbody;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTemplates() {
		return templates;
	}
	public void setTemplates(List<String> templates) {
		this.templates = templates;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public List<Entities> getEntities() {
		return entities;
	}
	public void setEntities(List<Entities> entities) {
		this.entities = entities;
	}
	public String getRequestbody() {
		return requestbody;
	}
	public void setRequestbody(String requestbody) {
		this.requestbody = requestbody;
	}

}
