package com.distribuida.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExaRegsitroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaRegsitroApplication.class, args);
	}
}
