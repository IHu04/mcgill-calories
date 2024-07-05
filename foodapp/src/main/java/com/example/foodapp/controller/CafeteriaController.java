package com.example.foodapp.controller;

import com.example.foodapp.models.Cafeteria;
import com.example.foodapp.service.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafeterias")
public class CafeteriaController {

    @Autowired
    private CafeteriaService cafeteriaService;

    @GetMapping
    public List<Cafeteria> getAllCafeterias() {
        return cafeteriaService.getAllCafeterias();
    }

    @GetMapping("/{id}")
    public Cafeteria getCafeteriaById(@PathVariable Long id) {
        return cafeteriaService.getCafeteriaById(id);
    }

    @PostMapping
    public Cafeteria createCafeteria(@RequestBody Cafeteria cafeteria) {
        return cafeteriaService.createCafeteria(cafeteria);
    }

    @DeleteMapping("/{id}")
    public void deleteCafeteria(@PathVariable Long id) {
        cafeteriaService.deleteCafeteria(id);
    }
}

