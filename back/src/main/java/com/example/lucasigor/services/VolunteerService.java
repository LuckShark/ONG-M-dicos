package com.example.lucasigor.services;

import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    //GET ALL
    public List<Volunteer> findAll() {
        return volunteerRepository.findAll();
    }

    //GET BY ID
    public Volunteer findById(Long id) {
        Optional<Volunteer> result = volunteerRepository.findById(id);
        return  result.orElseThrow(()-> new RuntimeException("Voluntário não encontrado"));
    }

    //POST - New volunteer
    public Volunteer save(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }
}
