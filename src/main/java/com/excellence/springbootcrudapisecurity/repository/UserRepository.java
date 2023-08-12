package com.excellence.springbootcrudapisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellence.springbootcrudapisecurity.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
//	User findByUsername(String username);


	User findById(int id);


}

