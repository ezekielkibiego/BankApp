package com.kibiego.BankApp.deposit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.MAY;

@Configuration
public class DepositConfig {

    @Bean
    CommandLineRunner commandLineRunner(DepositRepository repository) {
        return args -> {
            Deposit Ezekiel = new Deposit(
                    "Ezekiel",
                    "Kibiego",
                    "kibiezekiel@gmail.com",
                    "current",
                    224455667,
                    9000D,
                    0.00D,
                    LocalDate.of(2022, MAY, 24 )

            );
            Deposit Nelly = new Deposit(
                    "Nelly",
                    "Peters",
                    "nelly@gmail.com",
                    "salary",
                    224455888,
                    5000D,
                    0.00D,
                    LocalDate.of(2022, MAY, 24 )

            );

            repository.saveAll(
                    List.of(Ezekiel, Nelly)
            );
        };
    }
}
