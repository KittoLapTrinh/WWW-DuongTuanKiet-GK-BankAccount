package com.example.duongtuankiet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_account")
@NamedQueries({
        @NamedQuery(
                name = "Account.filterByAmount",
                query = "SELECT a FROM Account a WHERE a.amount BETWEEN :minAmount AND :maxAmount"
        )
})
public class Account {
    @Id
    @Column(name = "account_number", nullable = false, length = 10)
    private String accountNumber;
    @Column(name = "owner_name", length = 155)
    private String ownerName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "owner_address")
    private String ownerAddress;
    private double amount;

    public Account() {
    }

    public Account(String accountNumber, String ownerName, String cardNumber, String ownerAddress, double amount) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.ownerAddress = ownerAddress;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
