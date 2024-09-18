package com.example.foodapp.models;

public class FoodRequest {
    private String name;
    private float calories;
    private float protein;
    private float fat;
    private float carbohydrates;
    private float fiber;
    private float sugar;
    private float sodium;
    private Long cafeteriaId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public float getFiber() {
        return fiber;
    }

    public void setFiber(float fiber) {
        this.fiber = fiber;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public Long getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Long cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }
}

