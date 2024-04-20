package com.bankapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(
		title = "Account Open API",
		version = "1.0.6",
		description = "Account Open API Documentation."),
servers = @Server(
		url = "http://localhost:9090",
		description = "Account Open API URL"))

public class BankingApplicationRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplicationRestApiApplication.class, args);
	}

}
