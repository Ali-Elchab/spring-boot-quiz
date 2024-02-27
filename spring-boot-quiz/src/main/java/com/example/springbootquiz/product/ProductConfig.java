package com.example.springbootquiz.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
        @SuppressWarnings("null")
        @Bean
        CommandLineRunner commandLineRunner(ProductRepository repository) {
                return args -> {
                        Product pimplePatch = new Product(
                                        1L,
                                        "patch",
                                        "remove pimples",
                                        "pimple patches",
                                        "2/25/2022"

                        );
                        Product sleepPatch = new Product(
                                        2L,
                                        "energy patch",
                                        "helps you sleep",
                                        "sleep patches",
                                        "2/25/2022"

                        );

                        repository.saveAll(
                                        List.of(pimplePatch, sleepPatch));
                };
        }
}