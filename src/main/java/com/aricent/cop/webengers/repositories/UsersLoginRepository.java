package com.aricent.cop.webengers.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.aricent.cop.webengers.models.Users;


/**
 * This is a custom repository class for users-login based on mongo template
 */
@Repository
public class UsersLoginRepository {

	@Autowired
	MongoTemplate mongoTemplate;


	public Users searchUserByUsername(String username) {

		return mongoTemplate.findById(username, Users.class);
	}

}
