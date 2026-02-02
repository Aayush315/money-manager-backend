package com.ayushkr.money_manager_backend.repository;

import com.ayushkr.money_manager_backend.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUserId(String userId);
}
