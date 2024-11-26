package com.example.lucasigor.services;

import com.example.lucasigor.entities.Work;
import com.example.lucasigor.exceptions.ResourceNotFoundException;
import com.example.lucasigor.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    @Autowired
    private WorkRepository repository;

    //GET ALL jobs
    public List<Work> findAll() {
        return repository.findAll();
    }

    //GET job BY ID
    public Work findById(Long id) {
        Optional<Work> result = repository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
    }

    //POST - New Job
    public Work save(Work work) {
        return repository.save(work);
    }

    //DELETE - Excluir Job
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Trabalho não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }

}
