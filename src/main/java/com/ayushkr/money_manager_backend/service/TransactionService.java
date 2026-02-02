package com.ayushkr.money_manager_backend.service;

import com.ayushkr.money_manager_backend.model.Transaction;
import com.ayushkr.money_manager_backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public Transaction addTransaction(Transaction t, String userId) {
        t.setUserId(userId);
        t.setEditableUntil(t.getDateTime().plusHours(12));
        return repo.save(t);
    }

    public Transaction editTransaction(String id, Transaction updated, String userId) {
        Transaction existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
        if (!existing.getUserId().equals(userId) || LocalDateTime.now().isAfter(existing.getEditableUntil())) {
            throw new RuntimeException("Cannot edit after 12 hours or unauthorized");
        }
        updated.setId(id);
        updated.setUserId(userId);
        updated.setEditableUntil(existing.getEditableUntil());
        return repo.save(updated);
    }

    public List<Transaction> getFiltered(String userId, String division, String category, LocalDateTime start, LocalDateTime end) {
        List<Transaction> transactions = repo.findByUserIdAndDateTimeBetween(userId, start, end);
        return transactions.stream()
                .filter(t -> division == null || t.getDivision().equals(division))
                .filter(t -> category == null || t.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public Map<String, Double> getSummary(String userId) {
        List<Transaction> all = repo.findByUserIdAndDateTimeBetween(userId, LocalDateTime.now().minusYears(1), LocalDateTime.now());
        return all.stream()
                .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingDouble(Transaction::getAmount)));
    }

    public List<Map<String, Object>> getDashboardData(String userId, String view) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start;

        switch (view) {
            case "weekly": start = now.minusWeeks(1); break;
            case "monthly": start = now.minusMonths(1); break;
            case "yearly": start = now.minusYears(1); break;
            default: start = now.minusMonths(1);
        }

        List<Transaction> transactions =
                repo.findByUserIdAndDateTimeBetweenForAggregation(userId, start, now);

        return transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getDateTime().toLocalDate().toString()
                ))
                .entrySet()
                .stream()
                .map(e -> {
                    Map<String, Object> map = new java.util.HashMap<>();
                    map.put("date", e.getKey());
                    map.put("income",
                            e.getValue().stream()
                                    .filter(t -> "INCOME".equals(t.getType()))
                                    .mapToDouble(Transaction::getAmount)
                                    .sum()
                    );
                    map.put("expense",
                            e.getValue().stream()
                                    .filter(t -> "EXPENSE".equals(t.getType()))
                                    .mapToDouble(Transaction::getAmount)
                                    .sum()
                    );
                    return map;
                })
                .collect(Collectors.toList());
    }
}