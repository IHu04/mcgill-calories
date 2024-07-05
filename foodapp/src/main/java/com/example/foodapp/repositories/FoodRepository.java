package com.example.foodapp.repositories;

import com.example.foodapp.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}

