package com.poo.trabalho_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class TrabalhoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoFinalApplication.class, args);
	}

}
