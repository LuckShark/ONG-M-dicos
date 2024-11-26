package com.example.lucasigor.services;

import com.example.lucasigor.entities.VoluntWorkEnrollment;
import com.example.lucasigor.repositories.VoluntWorkEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntWorkEnrollmentService {

    @Autowired
    private VoluntWorkEnrollmentRepository repository;

    //GET ALL
    public List<VoluntWorkEnrollment> findAll() {
        return repository.findAll();
    }

    //GET BY ID
    public  VoluntWorkEnrollment findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
    }

    //POST
    public VoluntWorkEnrollment save(VoluntWorkEnrollment enrollment) {
        return repository.save(enrollment);
    }

    //PUT
    public VoluntWorkEnrollment update(Long id, VoluntWorkEnrollment enrollment) {
        VoluntWorkEnrollment existing = findById(id);
        existing.setVolunteers(enrollment.getVolunteers());
        existing.setVoluntWork(enrollment.getVoluntWork());
        existing.setStartDate(enrollment.getStartDate());
        existing.setEndDate(enrollment.getEndDate());
        return repository.save(existing);
    }

    //DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
