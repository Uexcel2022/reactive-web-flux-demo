package com.uexcel.reactivewebfluxdemo.router;

import com.uexcel.reactivewebfluxdemo.handler.CustomerHandler;
import com.uexcel.reactivewebfluxdemo.handler.CustomerStreamHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    private final CustomerHandler customerHandler;
    private final CustomerStreamHandler customerStreamHandler;

    public RouterConfig(CustomerHandler customerHandler, CustomerStreamHandler customerStreamHandler) {
        this.customerHandler = customerHandler;
        this.customerStreamHandler = customerStreamHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> responseRouterFunction(){
        return RouterFunctions.route()
                .GET("/router/customers",customerHandler::getAllCustomer)//(not stream)returns objects
                .GET("/router/customers/stream",customerStreamHandler::getAllCustomerStream)
                .build();
    }
}
