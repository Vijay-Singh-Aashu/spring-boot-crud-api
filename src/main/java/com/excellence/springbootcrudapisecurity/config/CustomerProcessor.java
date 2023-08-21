package com.excellence.springbootcrudapisecurity.config;

import org.springframework.batch.item.ItemProcessor;

import com.excellence.springbootcrudapisecurity.models.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }
}
