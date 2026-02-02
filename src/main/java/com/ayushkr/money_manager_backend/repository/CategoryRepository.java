package com.ayushkr.money_manager_backend.repository;

import com.ayushkr.money_manager_backend.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category,String> {
    List<Category> findByDivision(String division);
}
