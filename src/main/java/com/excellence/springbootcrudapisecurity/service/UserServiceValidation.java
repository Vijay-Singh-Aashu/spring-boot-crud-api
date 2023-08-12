package com.excellence.springbootcrudapisecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellence.springbootcrudapisecurity.dto.UserDto;
import com.excellence.springbootcrudapisecurity.exception.UserNotFoundException;
import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.repository.UserRepository;

@Service
public class UserServiceValidation {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserDto userDto) {
		User user = User.build(0l, userDto.getUsername(), userDto.getEmail(),
				userDto.getPassword(), userDto.getRole());
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		User user = userRepository.findById(id);
		if(user!=null) {
			return user;
		} else {
			throw new UserNotFoundException("user not found with id : "+id);
		}
	}

	
}