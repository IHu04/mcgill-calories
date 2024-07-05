package com.example.foodapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float age;
    private float height;
    private float weight;
    private float bmi;

    @OneToOne(mappedBy = "profile")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getAge(){
        return age;
    }
    public void setAge(float age){
        this.age = age;
    }

    public float getHeight(){
        return height;
    }
    public void setHeight(float height){
        this.height = height;
    }
    public float getWeight(){
        return weight;
    }
    public void setWeight(float weight){
        this.weight = weight;
    }
    public float getBMI(){
        return bmi;
    }
    public void setBMI(float bmi){
        this.bmi = bmi;
    }
}
