package com.aricent.cop.webengers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aricent.cop.webengers.models.MessageRequest;
import com.aricent.cop.webengers.models.MessageResponse;
import com.aricent.cop.webengers.service.ApiAiServiceImpl;
import com.aricent.cop.webengers.service.MLService;
import com.aricent.cop.webengers.service.MLServiceFactory;


@RestController
public class MessageController {

	@Autowired
	ApiAiServiceImpl restApiService;
	
	@Autowired
	MLServiceFactory mlFactory;
	
//	@CrossOrigin
	@RequestMapping(value = "/message", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> message(@RequestBody MessageRequest message) {
		MessageResponse response = null;
		try {
			MLService mlService = mlFactory.getMLService();
			response = mlService.processMessage(message.getMessage(), message.getSessionId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
