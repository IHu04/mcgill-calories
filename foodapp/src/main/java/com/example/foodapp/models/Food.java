package com.example.foodapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "cafeteria_id", nullable = false)
    private Cafeteria cafeteria;

    private Float calories;
    private Float protein;
    private Float fat;
    private Float carbohydrates;
    private Float fiber;
    private Float sugar;
    private Float sodium;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Float getFiber() {
        return fiber;
    }

    public void setFiber(Float fiber) {
        this.fiber = fiber;
    }

    public Float getSugar() {
        return sugar;
    }

    public void setSugar(Float sugar) {
        this.sugar = sugar;
    }

    public Float getSodium() {
        return sodium;
    }

    public void setSodium(Float sodium) {
        this.sodium = sodium;
    }
}
