package com.kibiego.BankApp.withdraw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.MAY;

@Configuration
public class WithdrawConfig {

    @Bean
    CommandLineRunner commandLineRunner(WithdrawRepository repository) {
        return args -> {
            Withdraw Ezekiel = new Withdraw(
                    "Ezekiel",
                    "Kibiego",
                    "kibiezekiel@gmail.com",
                    "current",
                    224455667,
                    9000D,
                    100000D,
                    LocalDate.of(2022, MAY, 24 )
            );

            Withdraw Nelly = new Withdraw(
                    "Nelly",
                    "Peters",
                    "nelly@gmail.com",
                    "salary",
                    224455888,
                    5000D,
                    40000D,
                    LocalDate.of(2022, MAY, 24 )

            );

            repository.saveAll(
                    List.of(Ezekiel, Nelly)
            );
        };
    }
}
