package com.kibiego.BankApp.deposit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/deposit")
public class DepositController {
    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping
    public List<Deposit> getDeposits() {

        return depositService.getDeposits();
    }

    @PostMapping
    public void registerNewDeposit(@RequestBody Deposit deposit) {
        depositService.addNewDeposit(deposit);
    }

    @DeleteMapping(path = "{depositId}")
    public void deleteDeposit(@PathVariable("depositId") Long depositId) {
        depositService.deleteDeposit(depositId);
    }

    @PutMapping(path = "{depositId}")
    public void updateDeposit(

            @PathVariable("depositId") Long depositId,
            @RequestParam(required = false) String email) {

        depositService.updateDeposit(depositId,email);
    }

}
