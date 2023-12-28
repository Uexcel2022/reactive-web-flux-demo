package com.uexcel.reactivewebfluxdemo.service;

import com.uexcel.reactivewebfluxdemo.dto.Customer;
import com.uexcel.reactivewebfluxdemo.dao.CustomerDao;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
public class CustomerServiceImp implements  CustomerService {
    @Override
    public Flux<Customer> getAllCustomer() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getAllCustomer();
    }

    @Override
    public List<Customer> loadAllCustomer() {
        CustomerDao customerDao = new CustomerDao();
        return  customerDao.loadAllCustomer();
    }
}
