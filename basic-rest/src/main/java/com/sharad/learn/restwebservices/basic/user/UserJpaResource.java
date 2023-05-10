/**
 * 
 */
package com.sharad.learn.restwebservices.basic.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.sharad.learn.restwebservices.basic.exception.PostNotFoundException;
import com.sharad.learn.restwebservices.basic.exception.UserNotFoundException;
import com.sharad.learn.restwebservices.basic.jpa.PostRepository;
import com.sharad.learn.restwebservices.basic.jpa.UserDetailsRepository;

import jakarta.validation.Valid;

/**
 * @author koxkakku
 *
 */
@RestController
public class UserJpaResource {
	@Autowired
	private UserDetailsRepository repository;
	@Autowired
	private PostRepository postRepository;
	
	
	@GetMapping("/jpa/users")
	public List<UserDetail> retrieveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{userId}")
	public UserDetail retrieveUser(@PathVariable int userId){
		Optional<UserDetail> findUserById = repository.findById(userId);
		if(findUserById.isEmpty())
			throw new UserNotFoundException(String.format("user with id :%d not found" ,userId ));
		return findUserById.get();
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<UserDetail> createUser(@Valid @RequestBody UserDetail user) {
		UserDetail savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{userId}")
						.buildAndExpand(savedUser.getUserId())
						.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/jpa/users/{userId}")
	public void removeUser(@PathVariable int userId){
		repository.deleteById(userId);
	}
	@GetMapping("/jpa/hateoas/users/{userId}")
	public EntityModel<UserDetail> retrieveUserHateoas(@PathVariable int userId){
		Optional<UserDetail> findUserById = repository.findById(userId);
		if(findUserById.isEmpty())
			throw new UserNotFoundException(String.format("user with id :%d not found" ,userId ));
		EntityModel<UserDetail> entityModel = EntityModel.of(findUserById.get());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	@GetMapping("/jpa/users/{userId}/posts")
	public List<UserPost> retrievePostsOfUser(@PathVariable int userId){
		Optional<UserDetail> findUserById = repository.findById(userId);
		if(findUserById.isEmpty())
			throw new UserNotFoundException(String.format("user with id :%d not found" ,userId ));
		return findUserById.get().getPosts();
	}
	@PostMapping("/jpa/users/{userId}/posts")
	public ResponseEntity<UserPost> createPostsForUser(@PathVariable int userId,@Valid @RequestBody UserPost post){
		Optional<UserDetail> findUserById = repository.findById(userId);
		if(findUserById.isEmpty())
			throw new UserNotFoundException(String.format("user with id :%d not found" ,userId ));
		post.setUser(findUserById.get());
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{userId}")
				.buildAndExpand(post.getPostId())
				.toUri();
		return  ResponseEntity.created(location).build();
	}
	@GetMapping("/jpa/users/{userId}/posts/{postid}")
	public UserPost retrievePostOfUser(@PathVariable int userId, @PathVariable int postid){
		Optional<UserDetail> findUserById = repository.findById(userId);
		if(findUserById.isEmpty())
			throw new UserNotFoundException(String.format("user with id :%d not found" ,userId ));
		UserPost findByIdAndUserDetailsId = postRepository.findByPostIdAndUserUserId(postid,userId);
		if(null==findByIdAndUserDetailsId)
			throw new PostNotFoundException(String.format("Post not found with post id %d for user %d",postid,userId));
		return findByIdAndUserDetailsId;
	}
}
