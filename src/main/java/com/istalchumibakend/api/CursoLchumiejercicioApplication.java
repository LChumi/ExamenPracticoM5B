package com.istalchumibakend.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class CursoLchumiejercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoLchumiejercicioApplication.class, args);
	}

}
