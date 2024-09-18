package com.example.foodapp.controller;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import com.example.foodapp.models.Food;
import com.example.foodapp.models.FoodRequest;
import com.example.foodapp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @PostMapping("/by-calories")
    public List<Food> getFoodsByCalories(@RequestBody Map<String, Integer> requestBody) {
        int calorieGoal = requestBody.get("calories");
        System.out.println(calorieGoal);
        int flexibility = 100;
        List<Food> foods = foodService.getAllFoods();
        int n = foods.size();
        int[][] dp = new int[n + 1][calorieGoal + 1];
        List<Food>[][] foodCombinations = new ArrayList[n + 1][calorieGoal + 1];

        // Initialize the DP table and food combinations
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= calorieGoal; j++) {
                dp[i][j] = 0;
                foodCombinations[i][j] = new ArrayList<>();
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            Food currentFood = foods.get(i - 1);
            for (int j = 1; j <= calorieGoal; j++) {
                int currentCalories = Math.round(currentFood.getCalories());
                if (currentFood.getCalories() <= j) {
                    if (dp[i - 1][j] > dp[i - 1][j - currentCalories] + currentFood.getCalories()) {
                        dp[i][j] = dp[i - 1][j];
                        foodCombinations[i][j] = new ArrayList<>(foodCombinations[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j - currentCalories] + currentCalories;
                        foodCombinations[i][j] = new ArrayList<>(foodCombinations[i - 1][j - currentCalories]);
                        foodCombinations[i][j].add(currentFood);
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                    foodCombinations[i][j] = new ArrayList<>(foodCombinations[i - 1][j]);
                }
            }
        }

        // Find the best result within the flexibility range
        List<Food> bestCombination = new ArrayList<>();
        for (int j = calorieGoal; j >= calorieGoal - flexibility; j--) {
            if (dp[n][j] > dp[n][j - 1]) {
                bestCombination = foodCombinations[n][j];
                break;
            }
        }
        return bestCombination;
    }

    @PostMapping
    public Food createFood(@RequestBody FoodRequest request) {
        return foodService.createFoodWithCafeteria(request);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
}

