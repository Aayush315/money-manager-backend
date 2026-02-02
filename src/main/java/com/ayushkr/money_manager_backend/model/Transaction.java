package com.ayushkr.money_manager_backend.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "transactions")
@Data
public class Transaction {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public LocalDateTime getEditableUntil() {
        return editableUntil;
    }

    public void setEditableUntil(LocalDateTime editableUntil) {
        this.editableUntil = editableUntil;
    }

    @Id
    private String id;
    private String userId;  // For multi-user, but assuming single user
    private String type;    // INCOME, EXPENSE, TRANSFER
    private Double amount;
    private String description;
    private String category;
    private String division; // OFFICE, PERSONAL
    private LocalDateTime dateTime;
    private String fromAccountId;  // For transfers
    private String toAccountId;    // For transfers
    private LocalDateTime editableUntil;


}