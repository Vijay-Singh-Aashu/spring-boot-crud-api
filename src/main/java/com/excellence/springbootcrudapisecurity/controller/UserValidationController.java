package com.excellence.springbootcrudapisecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.springbootcrudapisecurity.dto.UserDto;
import com.excellence.springbootcrudapisecurity.exception.UserNotFoundException;
import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.service.UserServiceValidation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserValidationController {

	@Autowired
	private UserServiceValidation userServiceValidation;

	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
		return new ResponseEntity<>(userServiceValidation.saveUser(userDto), HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userServiceValidation.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(userServiceValidation.getUser(id));
	}

}
