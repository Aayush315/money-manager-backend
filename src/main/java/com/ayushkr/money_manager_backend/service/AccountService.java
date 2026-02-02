package com.ayushkr.money_manager_backend.service;


import com.ayushkr.money_manager_backend.model.Account;
import com.ayushkr.money_manager_backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public Account addAccount(Account a, String userId) {
        a.setUserId(userId);
        return repo.save(a);
    }

    public List<Account> getAccounts(String userId) {
        return repo.findByUserId(userId);
    }

    public void transfer(String fromId, String toId, Double amount, String userId) {
        Account from = repo.findById(fromId).orElseThrow();
        Account to = repo.findById(toId).orElseThrow();
        if (!from.getUserId().equals(userId) || from.getBalance() < amount) {
            throw new RuntimeException("Invalid transfer");
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        repo.save(from);
        repo.save(to);
    }
}
