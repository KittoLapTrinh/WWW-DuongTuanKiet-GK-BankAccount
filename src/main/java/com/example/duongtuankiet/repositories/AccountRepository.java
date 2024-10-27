package com.example.duongtuankiet.repositories;

import com.example.duongtuankiet.models.Account;
import com.example.duongtuankiet.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AccountRepository extends CRUDRepository<Account> {
    public AccountRepository(){
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }

    public List<Account> findAccountsByAmountRange(double minAmount, double maxAmount) {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.filterByAmount", Account.class);
        query.setParameter("minAmount", minAmount);
        query.setParameter("maxAmount", maxAmount);
        return query.getResultList();
    }
}
