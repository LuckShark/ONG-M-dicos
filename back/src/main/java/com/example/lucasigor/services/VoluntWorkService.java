package com.example.lucasigor.services;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.exceptions.ResourceNotFoundException;
import com.example.lucasigor.repositories.VoluntWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntWorkService {

    @Autowired
    private VoluntWorkRepository voluntWorkRepository;

    //GET ALL jobs
    public List<VoluntWork> findAll() {
        return voluntWorkRepository.findAll();
    }

    //GET job BY ID
    public VoluntWork findById(Long id) {
        Optional<VoluntWork> result = voluntWorkRepository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
    }

    //POST - New Job
    public VoluntWork save(VoluntWork voluntWork) {
        return voluntWorkRepository.save(voluntWork);
    }

    //DELETE - Excluir Job
    public void delete(Long id) {
        if (!voluntWorkRepository.existsById(id)) {
            throw new ResourceNotFoundException("Trabalho não encontrado com o id: " + id);
        }
        voluntWorkRepository.deleteById(id);
    }

}
