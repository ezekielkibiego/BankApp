package com.kibiego.BankApp.withdraw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/withdraw")
public class WithdrawController {

    private final WithdrawService withdrawService;

    @Autowired
    public WithdrawController(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @GetMapping
    public List<Withdraw> getWithdrawals() {
        return withdrawService.getWithdrawals();
    }

    public void registerNewWithdraw(@RequestBody Withdraw withdraw){
        withdrawService.addNewWithdraw(withdraw);
    }
}
