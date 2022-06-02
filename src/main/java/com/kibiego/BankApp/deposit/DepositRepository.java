package com.kibiego.BankApp.deposit;
import com.kibiego.BankApp.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  DepositRepository  extends JpaRepository<Deposit, Long> {

    Optional<Deposit> findDepositByAccountNumber(Integer accountNumber);

    Optional<Deposit> findDepositByEmail(String email);

    Optional<Deposit> findDepositByAmountToDeposit(double amountToDeposit);
}

