package com.example.duongtuankiet.data;

import com.example.duongtuankiet.models.Account;
import com.example.duongtuankiet.repositories.AccountRepository;

public class AddData {
    public static void main(String[] args) {
        Account a1 = new Account("2616598821", "Duong Tuan Kiet", "103872670948","12 Nguyen Van Bao", 100000.0);
        Account a2 = new Account("1234567894", "Nguyen Van Hau", "208872670978","17 Nguyen Van Bao", 200000.0);
        Account a3 = new Account("3246195577", "Huynh Le Tam Nhu", "303871670979","20 Nguyen Van Bao", 200000.0);
        AccountRepository repository = new AccountRepository();
        repository.insert(a1);
        repository.insert(a2);
        repository.insert(a3);
    }
}
