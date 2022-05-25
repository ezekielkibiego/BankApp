package com.kibiego.BankApp.deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.time.Month.MAY;

@Service
public class DepositService {
    private final DepositRepository depositRepository;

    @Autowired
    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public List<Deposit> getDeposits() {
        return depositRepository.findAll();
    }

    public void addNewDeposit(Deposit deposit) {
        Optional<Deposit> depositOptional = depositRepository.findDepositByAccountNumber(deposit.getAccountNumber());

        if (depositOptional.isPresent()) {
            throw new IllegalStateException("Account Number Taken");
        }
        depositRepository.save(deposit);
    }

    public void deleteDeposit(Long depositId) {
        depositRepository.findById(depositId);
       boolean exists = depositRepository.existsById(depositId);
       if (!exists) {
           throw new IllegalStateException(
                   "Account with id " + depositId + " does not exist");
       }
       depositRepository.deleteById(depositId);
    }

    @Transactional
    public void updateDeposit(Long depositId,
                              String email) {
        Deposit deposit = depositRepository.findById(depositId)
                .orElseThrow(() -> new IllegalStateException(
                        "Account with id " + depositId + " does not exist"
                ));
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(deposit.getEmail(), email)) {
            Optional<Deposit> depositOptional = depositRepository
                    .findDepositByEmail(email);
            if (depositOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            deposit.setEmail(email);
        }
    }
}
