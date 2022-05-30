package com.kibiego.BankApp.withdraw;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class Withdraw {

    @Id
    @SequenceGenerator(
            name = "withdraw_sequence",
            sequenceName = "withdraw_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "withdraw_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String bankType;
    private Integer accountNumber;
    private Double amountToWithdraw;
    private Double accountBalance;
    private LocalDate withdrewOn;

    public Withdraw() {
    }

    public Withdraw(Long id,
                    String firstName,
                    String lastName,
                    String email,
                    String bankType,
                    Integer accountNumber,
                    Double amountToWithdraw,
                    Double accountBalance,
                    LocalDate withdrewOn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bankType = bankType;
        this.accountNumber = accountNumber;
        this.amountToWithdraw = amountToWithdraw;
        this.accountBalance = accountBalance;
        this.withdrewOn = withdrewOn;
    }

    public Withdraw(String firstName,
                    String lastName,
                    String email,
                    String bankType,
                    Integer accountNumber,
                    Double amountToWithdraw,
                    Double accountBalance,
                    LocalDate withdrewOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bankType = bankType;
        this.accountNumber = accountNumber;
        this.amountToWithdraw = amountToWithdraw;
        this.accountBalance = accountBalance - amountToWithdraw;
        this.withdrewOn = withdrewOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmountToWithdraw() {
        return amountToWithdraw;
    }

    public void setAmountToWithdraw(Double amountToWithdraw) {
        this.amountToWithdraw = amountToWithdraw;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LocalDate getWithdrewOn() {
        return withdrewOn;
    }

    public void setWithdrewOn(LocalDate withdrewOn) {
        this.withdrewOn = withdrewOn;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", bankType='" + bankType + '\'' +
                ", accountNumber=" + accountNumber +
                ", amountToWithdraw=" + amountToWithdraw +
                ", accountBalance=" + accountBalance +
                ", withdrewOn=" + withdrewOn +
                '}';
    }
}
