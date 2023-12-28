package com.uexcel.reactivewebfluxdemo.service;

import com.uexcel.reactivewebfluxdemo.dto.Customer;
import reactor.core.publisher.Flux;

import java.util.List;


public interface CustomerService {
    Flux<Customer> getAllCustomer();


    List<Customer> loadAllCustomer();

}
