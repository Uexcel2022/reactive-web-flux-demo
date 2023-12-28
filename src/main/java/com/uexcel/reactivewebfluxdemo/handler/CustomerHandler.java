package com.uexcel.reactivewebfluxdemo.handler;

import com.uexcel.reactivewebfluxdemo.dto.Customer;
import com.uexcel.reactivewebfluxdemo.dao.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CustomerHandler {

    private  final CustomerDao customerDao;

    public CustomerHandler(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Mono<ServerResponse> getAllCustomer(ServerRequest request){
        Flux<Customer> customerList = customerDao.getCustomerList();
        return ServerResponse.ok().body(customerList,Customer.class);
    }
}
