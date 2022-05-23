package com.kibiego.BankApp.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer Ezekiel = new Customer(
                    "Ezekiel",
                    "Kibiego",
                    "kibiezekiel@gmail.com",
                    1234567890,
                    20000D
            );
            Customer Dis = new Customer(
                    "Dis",
                    "Nya",
                    "disnya@gmail.com",
                    1987654321,
                    50000D
            );
            repository.saveAll(
                    List.of(Ezekiel, Dis)
            );
        };
    }
}
