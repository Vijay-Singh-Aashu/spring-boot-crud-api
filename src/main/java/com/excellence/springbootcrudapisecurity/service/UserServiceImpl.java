//package com.excellence.springbootcrudapisecurity.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.excellence.springbootcrudapisecurity.dto.UserDto;
//import com.excellence.springbootcrudapisecurity.models.User;
//import com.excellence.springbootcrudapisecurity.repository.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	private UserRepository userRepository;
//
//	public UserServiceImpl(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public User findByUsername(String username) {
//		return userRepository.findByUsername(username);
//	}
//
//	@Override
//	public User save(UserDto userDto) {
//		User user = new User(userDto.getUsername(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole());
//		return userRepository.save(user);
//	}
//
//}
