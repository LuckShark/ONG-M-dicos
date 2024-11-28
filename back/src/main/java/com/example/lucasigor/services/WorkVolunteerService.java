package com.example.lucasigor.services;

import com.example.lucasigor.entities.Work;
import com.example.lucasigor.entities.WorkVolunteer;
import com.example.lucasigor.exceptions.ResourceNotFoundException;
import com.example.lucasigor.repositories.WorkVolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkVolunteerService {

    @Autowired
    private WorkVolunteerRepository repository;

    public List<WorkVolunteer> findAll() {
        return repository.findAll();
    }

    public WorkVolunteer findById(Long id) {
        Optional<WorkVolunteer> result = repository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
    }

    public WorkVolunteer save(WorkVolunteer workVolunteer) {
        return repository.save(workVolunteer);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Trabalho não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }

}
