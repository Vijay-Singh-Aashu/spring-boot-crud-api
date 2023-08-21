package com.excellence.springbootcrudapisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.springbootcrudapisecurity.models.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
