package com.ayushkr.money_manager_backend.controller;

import com.ayushkr.money_manager_backend.model.Account;
import com.ayushkr.money_manager_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<Account> add(@RequestBody Account a, Authentication auth) {
        return ResponseEntity.ok(service.addAccount(a, auth.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Account>> get(Authentication auth) {
        return ResponseEntity.ok(service.getAccounts(auth.getName()));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Map<String, Object> transferData, Authentication auth) {
        String fromId = (String) transferData.get("fromId");
        String toId = (String) transferData.get("toId");
        Double amount = ((Number) transferData.get("amount")).doubleValue();
        service.transfer(fromId, toId, amount, auth.getName());
        return ResponseEntity.ok("Transfer successful");
    }
}
