package com.ayushkr.money_manager_backend.service;

import com.ayushkr.money_manager_backend.model.Category;
import com.ayushkr.money_manager_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> getCategories(String division) {
        return division != null ? repo.findByDivision(division) : repo.findAll();
    }
}