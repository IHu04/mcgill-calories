package com.example.foodapp.service;


import com.example.foodapp.models.Cafeteria;
import com.example.foodapp.models.Food;
import com.example.foodapp.models.FoodRequest;
import com.example.foodapp.repositories.CafeteriaRepository;
import com.example.foodapp.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

     @Autowired
    private CafeteriaRepository cafeteriaRepository;

    @Transactional
    public Food createFoodWithCafeteria(FoodRequest foodRequest) {
        Cafeteria cafeteria = cafeteriaRepository.findById(foodRequest.getCafeteriaId())
                .orElseThrow(() -> new IllegalArgumentException("Cafeteria not found"));
        Food food = new Food();
        food.setName(foodRequest.getName());
        food.setCalories(foodRequest.getCalories());
        food.setProtein(foodRequest.getProtein());
        food.setFat(foodRequest.getFat());
        food.setCarbohydrates(foodRequest.getCarbohydrates());
        food.setFiber(foodRequest.getFiber());
        food.setSugar(foodRequest.getSugar());
        food.setSodium(foodRequest.getSodium());
        food.setCafeteria(cafeteria);

        return foodRepository.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}

