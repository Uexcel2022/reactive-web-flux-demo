package com.uexcel.reactivewebfluxdemo.handler;

import com.uexcel.reactivewebfluxdemo.dto.Customer;
import com.uexcel.reactivewebfluxdemo.dao.CustomerDao;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    private final CustomerDao customerDao;

    public CustomerStreamHandler(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Mono<ServerResponse> getAllCustomerStream(ServerRequest request){
        Flux<Customer> customerFlux = customerDao.getAllCustomer();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerFlux,Customer.class);
    }
}
