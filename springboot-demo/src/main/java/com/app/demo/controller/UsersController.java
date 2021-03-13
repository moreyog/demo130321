package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.response.User;
import com.app.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService userService;
	
	@GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		if(true)
			throw new NullPointerException("This is test for NPE");
		return  user == null ? new ResponseEntity<User>(user, HttpStatus.NOT_FOUND): new ResponseEntity<User>(user,HttpStatus.OK) ;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println(user);
		userService.createUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@PutMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
		System.out.println("User with Id = " + userId + "updated successfully with details : " + user);
		userService.updateUser(userId, user);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
