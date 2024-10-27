package com.example.duongtuankiet.services.impl;

import com.example.duongtuankiet.models.Account;
import com.example.duongtuankiet.repositories.AccountRepository;
import com.example.duongtuankiet.services.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    public AccountServiceImpl(){
        repository = new AccountRepository();
    }
    @Override
    public List<Account> getAllAccount() {
        return repository.getAll(Account.class);
    }

    @Override
    public boolean insert(Account account) {
        return repository.insert(account);
    }

    @Override
    public List<Account> filterAmount(double minAmount, double maxAmount) {
        return repository.findAccountsByAmountRange(minAmount, maxAmount);
    }
}
