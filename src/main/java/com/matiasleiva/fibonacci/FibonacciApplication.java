package com.matiasleiva.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class FibonacciApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonacciApplication.class, args);
	}

}
