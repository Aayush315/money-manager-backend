package com.ayushkr.money_manager_backend.repository;

import com.ayushkr.money_manager_backend.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUserIdAndDivisionAndCategory(String userId, String division, String category);
    List<Transaction> findByUserIdAndDateTimeBetween(String userId, LocalDateTime start, LocalDateTime end);
    @Query("{ 'userId': ?0, 'dateTime': { $gte: ?1, $lt: ?2 } }")
    List<Transaction> findByUserIdAndDateTimeBetweenForAggregation(String userId, LocalDateTime start, LocalDateTime end);
}