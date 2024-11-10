package com.example.lucasigor.controller;


import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/volunteers")
public class VolunteerController {

    //Injeção de dependencia
    @Autowired
    private VolunteerRepository repository;

    @GetMapping
    public List<Volunteer> findAll() {
        List<Volunteer> result = repository.findAll();
        return result;
    }
}
