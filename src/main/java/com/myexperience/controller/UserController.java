package com.myexperience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myexperience.domain.User;
import com.myexperience.service.UserService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/{version}/myexperience", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
			)
	{
		List<User> userList = userService.findAll();
		return new ResponseEntity<>(userList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	{
		return userService.add(user);
		
	}
	
	@RequestMapping(value = "/users/searchByEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmail(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, 
			@ApiParam(name = "email") @PathVariable("email") String email
			)
	{
		User user = userService.findUserByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/users/searchByLastname/{lastname}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsersByLastName(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "lastname") @PathVariable("lastname") String lastname
			)
	{
		List<User> userList = userService.findUsersByLastName(lastname);
		return new ResponseEntity<>(userList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/users/searchByNames/{lastname}/{firstname}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsersByLastNameAndFistName(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "lastname") @PathVariable("lastname") String lastname,
			@ApiParam(name = "firstname") @PathVariable("firstname") String firstname
			)
	{
		List<User> userList = userService.findUsersByLastNameAndFistName(lastname, firstname);
		return new ResponseEntity<>(userList, HttpStatus.OK);		
	}

	@RequestMapping(value = "/user/login/{username}/{password}", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> logintolist(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "username", defaultValue ="m") @PathVariable("username") String  username,
			@ApiParam(name = "password",defaultValue = "1") @PathVariable("password") String password
	)
	{

		Boolean userFound=userService.login(username,password);
		if (userFound)
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		else
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
	}
}
