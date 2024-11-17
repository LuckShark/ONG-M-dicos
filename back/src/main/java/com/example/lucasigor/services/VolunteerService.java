package com.example.lucasigor.services;

import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    //GET ALL
    public List<Volunteer> findAll() {
        return volunteerRepository.findAll();
    }
}
