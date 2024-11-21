package com.example.lucasigor.services;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.repositories.VoluntWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntWorkService {

    @Autowired
    private VoluntWorkRepository voluntWorkRepository;

    //GET ALL
    public List<VoluntWork> findAll() {
        return voluntWorkRepository.findAll();
    }

}
