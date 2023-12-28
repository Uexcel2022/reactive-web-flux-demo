package com.uexcel.reactivewebfluxdemo.controller;

import com.uexcel.reactivewebfluxdemo.dto.Customer;
import com.uexcel.reactivewebfluxdemo.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
@RequestMapping("customer")
public class CustomerController {
   private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //TRADITIONAL WAY
    @GetMapping("/traditional-way")
    public List<Customer> getAllCustomer(){
        return customerService.loadAllCustomer();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> loadAllCustomer(){
       return customerService.getAllCustomer();
    }
}
