package com.example.lucasigor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Médicos Internos", version = "1.0", description = "API para gerenciamento de médicos voluntários e ONG parceiras"))
public class LucasigorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucasigorApplication.class, args);
	}

}
