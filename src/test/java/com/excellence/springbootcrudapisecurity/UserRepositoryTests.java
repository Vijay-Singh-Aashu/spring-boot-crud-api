package com.excellence.springbootcrudapisecurity;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.repository.UserRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	// Junit test for saveUser

	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveUserTest() {

		User user = User.builder().username("ram").email("ram@gmail.com").password("ram@123").role("Admin").build();

		userRepository.save(user);

		Assertions.assertThat(user.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getUsertTest() {

		User user = userRepository.findById(1L).get();

		Assertions.assertThat(user.getId()).isEqualTo(1L);

	}
	
	@Test
    @Order(3)
    public void getListOfUserTest(){

        List<User> employees = userRepository.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }
	
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){

    	User user = userRepository.findById(1L).get();

        user.setEmail("shreeramji@gmail.com");

        User userUpdated =  userRepository.save(user);

        Assertions.assertThat(userUpdated.getEmail()).isEqualTo("shreeramji@gmail.com");

    }
    
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){

        User user = userRepository.findById(1L).get();

        userRepository.delete(user);

        //employeeRepository.deleteById(1L);

        User user1 = null;

        Optional<User> optionalUser = userRepository.findByEmail("ram@gmail.com");

        if(optionalUser.isPresent()){
            user1 = optionalUser.get();
        }

        Assertions.assertThat(user1).isNull();
    }


}
