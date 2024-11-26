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

    //GET ALL jobs
    public List<WorkVolunteer> findAll() {
        return repository.findAll();
    }

    //GET job BY ID
    public WorkVolunteer findById(Long id) {
        Optional<WorkVolunteer> result = repository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
    }

    //POST - New Job
    public WorkVolunteer save(WorkVolunteer workVolunteer) {
        return repository.save(workVolunteer);
    }

    //DELETE - Excluir Job
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Trabalho não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }

}
