package com.kibiego.BankApp.withdraw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawService {
    private final WithdrawRepository withdrawRepository;

    @Autowired
    public WithdrawService(WithdrawRepository withdrawRepository) {
        this.withdrawRepository = withdrawRepository;
    }

    public List<Withdraw> getWithdrawals() {
        return withdrawRepository.findAll();
    }

    public void addNewWithdraw(Withdraw withdraw) {

    }
}
