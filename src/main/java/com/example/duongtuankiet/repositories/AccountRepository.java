package com.example.duongtuankiet.repositories;

import com.example.duongtuankiet.models.Account;
import com.example.duongtuankiet.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class AccountRepository extends CRUDRepository<Account> {
    public AccountRepository(){
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}
