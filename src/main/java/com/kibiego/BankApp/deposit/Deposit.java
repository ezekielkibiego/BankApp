package com.kibiego.BankApp.deposit;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class Deposit {


    @Id
    @SequenceGenerator(
            name = "deposit_sequence",
            sequenceName = "deposit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "deposit_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String bankType;
    private Integer accountNumber;
    private Double amountToDeposit;
    private Double accountBalance;
    private LocalDate depositedOn;

    public Deposit() {
    }

    public Deposit(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   String bankType,
                   Integer accountNumber,
                   Double amountToDeposit,
                   Double accountBalance,
                   LocalDate depositedOn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bankType = bankType;
        this.accountNumber = accountNumber;
        this.amountToDeposit = amountToDeposit;
        this.accountBalance = accountBalance;
        this.depositedOn = depositedOn;
    }

    public Deposit(String firstName,
                   String lastName,
                   String email,
                   String bankType,
                   Integer accountNumber,
                   Double amountToDeposit,
                   Double accountBalance,
                   LocalDate depositedOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bankType = bankType;
        this.accountNumber = accountNumber;
        this.amountToDeposit = amountToDeposit;
        this.accountBalance = accountBalance + amountToDeposit;
        this.depositedOn = depositedOn;
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

    public Double getAmountToDeposit() {
        return amountToDeposit;
    }

    public void setAmountToDeposit(Double amountToDeposit) {
        this.amountToDeposit = amountToDeposit;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LocalDate getDepositedOn() {
        return depositedOn;
    }

    public void setDepositedOn(LocalDate depositedOn) {
        this.depositedOn = depositedOn;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", bankType='" + bankType + '\'' +
                ", accountNumber=" + accountNumber +
                ", amountToDeposit=" + amountToDeposit +
                ", accountBalance=" + accountBalance +
                ", depositedOn=" + depositedOn +
                '}';
    }
}
