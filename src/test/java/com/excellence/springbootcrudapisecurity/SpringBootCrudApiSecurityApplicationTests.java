package com.excellence.springbootcrudapisecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.excellence.springbootcrudapisecurity.exception.UserNotFoundException;
import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.repository.UserRepository;
import com.excellence.springbootcrudapisecurity.service.UserServiceValidation;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootCrudApiSecurityApplicationTests {

	@Autowired
	private UserServiceValidation service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User("ram","ram@gmail.com","ram1234","user"),
						new User("shyam","shyam@gmail.com","shyam1234","user")).collect(Collectors.toList()));
		
		assertEquals(2, service.getAllUsers().size());

}
	
	@Test
	public void getUserById() throws UserNotFoundException {
		int id = 1;
		when(repository.findByUserId(id))
				.thenReturn(Stream.of(new User("ram","ram@gmail.com","ram1234","user")).collect(Collectors.toList()));
		assertEquals(1, service.getUsers(1).size());
	}

}