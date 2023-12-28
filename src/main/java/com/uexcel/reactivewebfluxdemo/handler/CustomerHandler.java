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

    public Mono<ServerResponse> findCustomerById(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("input"));
        Mono<Customer> customerMono = customerDao.getCustomerList().filter(c -> c.getId()==id).next();
        return ServerResponse.ok().body(customerMono, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request){
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> customer = customerMono.map(c -> c.getId()+ ": " + c.getCustomerName());
//        return ServerResponse.ok().body(customerMono,  Customer.class); //as object
        return ServerResponse.ok().body(customer,  String.class); //as String
    }
}
