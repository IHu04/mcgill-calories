package com.example.foodapp.service;

import com.example.foodapp.models.Cafeteria;
import com.example.foodapp.repositories.CafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CafeteriaService {

    @Autowired
    private CafeteriaRepository cafeteriaRepository;

    public List<Cafeteria> getAllCafeterias() {
        return cafeteriaRepository.findAll();
    }

    public Cafeteria getCafeteriaById(Long id) {
        return cafeteriaRepository.findById(id).orElse(null);
    }

    public Cafeteria saveCafeteria(Cafeteria cafeteria) {
        return cafeteriaRepository.save(cafeteria);
    }

    public void deleteCafeteria(Long id) {
        cafeteriaRepository.deleteById(id);
    }

    @Transactional
    public Cafeteria createCafeteria(Cafeteria cafeteria) {
        return cafeteriaRepository.save(cafeteria);
    }
}

