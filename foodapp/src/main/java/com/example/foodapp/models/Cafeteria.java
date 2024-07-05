package com.example.foodapp.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cafeterias")
public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "cafeteria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Food> foods;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getID() {
        return id;
    }
    public void setID(Long id) {
        this.id = id;
    }
    // Getters and setters
}

