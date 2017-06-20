package com.aricent.cop.webengers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.aricent.cop.webengers.models.Users;

/**
 * This is the default mongo repository class for
 * users collection for usual CRUD operations.
 *
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersMongoRepository extends MongoRepository<Users, String> {

}
