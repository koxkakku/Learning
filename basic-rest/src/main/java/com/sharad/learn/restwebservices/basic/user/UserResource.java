/**
 * 
 */
package com.sharad.learn.restwebservices.basic.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sharad.learn.restwebservices.basic.exception.UserNotFoundException;

import jakarta.validation.Valid;

/**
 * @author XY57013
 *
 */
@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User findUserById = service.findUserById(id);
		if(null==findUserById)
			throw new UserNotFoundException("id : " +id );
		return findUserById;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void removeUser(@PathVariable int id){
		service.deleteUserById(id);
	}
	@GetMapping("/hateoas/users/{id}")
	public EntityModel<User> retrieveUserHateoas(@PathVariable int id){
		User findUserById = service.findUserById(id);
		if(null==findUserById)
			throw new UserNotFoundException("id : " +id );
		EntityModel entityModel = EntityModel.of(findUserById);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
}
