package com.example.lucasigor.controller;


import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import com.example.lucasigor.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/volunteers")
public class VolunteerController {

    //Injeção de dependencia
    //@Autowired
    //private VolunteerRepository repository; AGORA VAMOS USAR O SERVICE

    @Autowired
    private VolunteerService volunteerService;

    @GetMapping
    public List<Volunteer> findAll() {
        return volunteerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Volunteer findById(@PathVariable Long id) {
        return volunteerService.findById(id);
    }
}
