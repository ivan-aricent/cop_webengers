package com.aricent.cop.webengers.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aricent.cop.webengers.service.ApiAiRestApiServiceImpl;
import com.google.gson.JsonObject;

@RestController
public class MessageController {

	@Autowired
	ApiAiRestApiServiceImpl restApiService;
	
	@CrossOrigin
	@RequestMapping(value = "/message", method = RequestMethod.POST /*, produces = "application/json"*/)
	public String message(@RequestBody String message) {
		String response = null;
		try {
			URI uri = restApiService.encodeUri(message);
			StringBuffer sb = restApiService.formRequestUrl(uri);
			response = restApiService.sendRestRequest(sb);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return response;
	}
}
