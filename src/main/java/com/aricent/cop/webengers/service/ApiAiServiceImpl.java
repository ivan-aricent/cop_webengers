package com.aricent.cop.webengers.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aricent.cop.webengers.common.ApiAiGlobals;
import com.aricent.cop.webengers.models.MessageResponse;
import com.aricent.cop.webengers.utils.ApiAiHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ApiAiServiceImpl implements MLService {

	private RestTemplate restClient = new RestTemplate();
	
	public MessageResponse processMessage(String message, String sessionId) {
		String speechValue = null; 
		try {
			URI query = ApiAiHelper.createQuery(message, sessionId);
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", ApiAiGlobals.BEARER_TOKEN);
			headers.set("Accept", ApiAiGlobals.CONTENT_TYPE);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> response = restClient.exchange(query, HttpMethod.GET, entity, String.class);
			if(response.getStatusCode() == HttpStatus.OK) {
				JsonObject responseJson = (JsonObject)new JsonParser().parse(response.getBody());
				JsonObject resultObject = responseJson.getAsJsonObject(ApiAiGlobals.RESULT);
				if(resultObject.get(ApiAiGlobals.ACTION_INCOMPLETE).getAsString() != null) {
					Boolean actionValue = resultObject.get(ApiAiGlobals.ACTION_INCOMPLETE).getAsBoolean();
					if(actionValue == false) {
						speechValue = resultObject.getAsJsonObject(ApiAiGlobals.FULFILLMENT).get(ApiAiGlobals.SPEECH).getAsString();
						JsonObject jsonParams = resultObject.getAsJsonObject("parameters");

						MessageResponse resp = new MessageResponse();
						resp.setResponse(speechValue);
						resp.setParameters((jsonParams.entrySet().isEmpty()) ? null : jsonParams.toString());
						resp.setComplete(true);
						return resp;
					}else {
						speechValue = resultObject.getAsJsonObject(ApiAiGlobals.FULFILLMENT).get(ApiAiGlobals.SPEECH).getAsString();

						MessageResponse resp = new MessageResponse();
						resp.setResponse(speechValue);
						resp.setComplete(false);
						return resp;
					}
				}
			}
		} catch (UnsupportedEncodingException ex) {
			//throw ex;
		}
		return null;
	}
}
	
