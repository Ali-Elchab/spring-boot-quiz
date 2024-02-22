package com.example.springbootquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import product.Product;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuizApplication.class, args);
	}

	@GetMapping
	public List<Product> hello(){
		return List.of(
				new Product(
						1L,
						"Sleep Patch",
						"Lets you sleep",
						"Relief Patches",
						"2/22/2024"
				)
		);
	}
}
