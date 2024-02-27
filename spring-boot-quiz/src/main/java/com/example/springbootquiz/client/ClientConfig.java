package com.example.springbootquiz.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @SuppressWarnings("null")
    @Bean
    CommandLineRunner commandLineRunner2(ClientRepository repository) {
        return args -> {
            Client ali = new Client(
                    1L,
                    "Ali Hadi",
                    "Elchab",
                    "761854452"
            );

            Client adam = new Client(
                    2L,
                    "Adam",
                    "Elchab",
                    "71444444"
            );

            repository.saveAll(
                    List.of(ali, adam));
        };
    }
}