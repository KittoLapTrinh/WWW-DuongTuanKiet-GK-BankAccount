package com.example.duongtuankiet.services;

import com.example.duongtuankiet.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    boolean insert (Account account);
    List<Account> filterAmount(double minAmount, double maxAmount);
}
