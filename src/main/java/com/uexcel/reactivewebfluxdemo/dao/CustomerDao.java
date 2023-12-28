package com.uexcel.reactivewebfluxdemo.dao;

import com.uexcel.reactivewebfluxdemo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {


    //TRADITIONAL WAY

    public List<Customer> loadAllCustomer(){
        return IntStream.rangeClosed(1,10)
                .mapToObj(i-> new Customer((long) i, "Customer "+1))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getAllCustomer(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count: "+i))
                .map(i -> new Customer((i.longValue()),"Customer"+i));
    }

    public Flux<Customer> getCustomerList(){
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("processing count: "+i))
                .map(i -> new Customer((i.longValue()),"Customer"+i));
    }
}
