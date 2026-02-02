package com.ayushkr.money_manager_backend.controller;


import com.ayushkr.money_manager_backend.model.Transaction;
import com.ayushkr.money_manager_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> add(@RequestBody Transaction t, Authentication auth) {
        return ResponseEntity.ok(service.addTransaction(t, auth.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> edit(@PathVariable String id, @RequestBody Transaction t, Authentication auth) {
        return ResponseEntity.ok(service.editTransaction(id, t, auth.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getFiltered(
            @RequestParam(required = false) String division,
            @RequestParam(required = false) String category,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            Authentication auth) {
        return ResponseEntity.ok(service.getFiltered(auth.getName(), division, category, start, end));
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Double>> getSummary(Authentication auth) {
        return ResponseEntity.ok(service.getSummary(auth.getName()));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<Map<String, Object>>> getDashboard(@RequestParam String view, Authentication auth) {
        return ResponseEntity.ok(service.getDashboardData(auth.getName(), view));
    }
}