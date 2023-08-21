package com.excellence.springbootcrudapisecurity.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellence.springbootcrudapisecurity.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> dueDate(LocalDateTime now);


}
