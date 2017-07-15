package com.aricent.cop.webengers.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.aricent.cop.webengers.models.IntentEntity;
import com.aricent.cop.webengers.models.ServiceDump;

@Repository
public class IntentEntityRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<IntentEntity> getAll(){
		Query query = new Query();
		query.fields().include("serviceId");
		query.fields().include("serviceName");		
		return mongoTemplate.find(query, IntentEntity.class);
	}
	
	public ServiceDump getServiceDumpByServiceId(String serviceId) {
		return mongoTemplate.findById(serviceId,IntentEntity.class).getServiceDump();
	}
}
