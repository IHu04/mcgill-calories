package com.example.foodapp.repositories;

import com.example.foodapp.models.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeteriaRepository extends JpaRepository<Cafeteria, Long> {
}

