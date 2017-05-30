package com.aricent.cop.webengers.service;

import java.net.URI;

import com.google.gson.JsonObject;

public interface RestApiService {

	public String sendRestRequest(StringBuffer s);
	
	public StringBuffer formRequestUrl(URI uri);
}
