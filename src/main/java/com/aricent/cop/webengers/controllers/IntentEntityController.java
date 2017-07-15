package com.aricent.cop.webengers.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aricent.cop.webengers.models.IntentEntity;
import com.aricent.cop.webengers.models.ServiceDump;
import com.aricent.cop.webengers.repositories.IntentEntityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class IntentEntityController {
	@Autowired
	IntentEntityRepository intententityrepository;
	
	@RequestMapping(value="/intententity", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getAll(){
		ArrayNode intentEntityJSON = null;
		List<IntentEntity> users = intententityrepository.getAll();
		String intentEntityData;
		try {
			intentEntityData = new ObjectMapper().writeValueAsString(users);
			intentEntityJSON = (ArrayNode)new ObjectMapper().readTree(intentEntityData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return new ResponseEntity<>(intentEntityJSON,HttpStatus.OK);
	}
	
	@RequestMapping(value="/servicedump/{serviceId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getServiceDump(@PathVariable String serviceId){
		ObjectNode intentEntityJSON = null;		
		ServiceDump serviceDump = intententityrepository.getServiceDumpByServiceId(serviceId);
		String intentEntityData;
		try {
			intentEntityData = new ObjectMapper().writeValueAsString(serviceDump);
			intentEntityJSON = (ObjectNode)new ObjectMapper().readTree(intentEntityData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return new ResponseEntity<>(intentEntityJSON,HttpStatus.OK);
	}
}
