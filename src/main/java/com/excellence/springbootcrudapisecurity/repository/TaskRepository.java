package com.excellence.springbootcrudapisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellence.springbootcrudapisecurity.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
