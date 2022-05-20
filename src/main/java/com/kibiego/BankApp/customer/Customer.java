package com.kibiego.BankApp.customer;

import javax.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "customer_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer ssn;
    private Integer accountNumber;
    private Double accountBalance;

    public Customer() {

    }

    public Customer(Long id,
                    String firstName,
                    String lastName,
                    String email,
                    Integer ssn,
                    Integer accountNumber,
                    Double accountBalance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ssn = ssn;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public Customer(String firstName,
                    String lastName,
                    String email,
                    Integer ssn,
                    Integer accountNumber,
                    Double accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ssn = ssn;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
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

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ssn=" + ssn +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }
}


