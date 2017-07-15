package com.aricent.cop.webengers.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "IntentEntity")
public class IntentEntity {
	
	@Id
	private String serviceId;
	
	private String serviceName;
	
	private ServiceDump serviceDump;
	
	private List<Entities> entityList;
	
	private String requestURL;
	
	private RequestBody requestBody;
	
	private String requestAuthToken;
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRequestURL() {
		return requestURL;
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	public String getRequestAuthToken() {
		return requestAuthToken;
	}

	public void setRequestAuthToken(String requestAuthToken) {
		this.requestAuthToken = requestAuthToken;
	}


	public ServiceDump getServiceDump() {
		return serviceDump;
	}

	public void setServiceDump(ServiceDump serviceDump) {
		this.serviceDump = serviceDump;
	}

	public List<Entities> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Entities> entityList) {
		this.entityList = entityList;
	}

	public RequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}
}
