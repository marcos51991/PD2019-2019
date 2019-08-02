package com.distribuida.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaGatewayApplication.class, args);
	}
//
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//	    return builder.routes()
//	    		.route( p->p
//	    				.path("/app1")
//	    				.uri( "http://127.0.0.1/aa" )
//	    			)
//	    		.build();
//	}

}
