package com.aricent.cop.webengers.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.aricent.cop.webengers.common.Globals;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ApiAiRestApiServiceImpl implements RestApiService {

	private RestTemplate restClient = new RestTemplate();
	
	public StringBuffer formRequestUrl(URI uri) {
		StringBuffer sb = new StringBuffer();
		sb.append(Globals.BASE_URL_API_AI).append("query?v=20150910"
				+ "&query=").append(uri).append("&lang=en").append("&sessionId=").append(Globals.SESSION);
		return sb;
	}
	
	public String sendRestRequest(StringBuffer sb) {
		URI url;
		String speechValue = null; // new JsonObject();
		try {
			url = new URI(sb.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", Globals.BEARER_TOKEN);
			headers.set("Accept", Globals.CONTENT_TYPE);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> response = restClient.exchange(url, HttpMethod.GET, entity, String.class);
			if(response.getStatusCode() == HttpStatus.OK) {
				JsonObject responseJson = (JsonObject)new JsonParser().parse(response.getBody());
				JsonObject resultObject = responseJson.getAsJsonObject(Globals.RESULT);
				if(resultObject.get(Globals.ACTION_INCOMPLETE).getAsString() != null) {
					Boolean actionValue = resultObject.get(Globals.ACTION_INCOMPLETE).getAsBoolean();
					if(actionValue == false) {
						speechValue = resultObject.getAsJsonObject(Globals.FULFILLMENT).get(Globals.SPEECH).getAsString();
						JsonObject jsonParams = resultObject.getAsJsonObject("parameters");
						
						return speechValue + "\n\n" + jsonParams.toString() ;
					}else {
						speechValue = resultObject.getAsJsonObject(Globals.FULFILLMENT).get(Globals.SPEECH).getAsString();
						return speechValue;
//						return resultObject.getAsJsonObject(Globals.FULFILLMENT);
					}
				}
			}
		} catch (URISyntaxException e) {

		}
		return speechValue;
	}
	
	public URI encodeUri(String message) throws UnsupportedEncodingException {
		UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(message);
		return urlBuilder.build().encode("UTF-8").toUri();
	}
}
	
