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

    public List<Work> findAll() {

        List<Work> works = repository.findAll();
        works.forEach(work -> work.setVagasOcupadas(work.getWorkVolunteers().size()));
        return works;
    }

    public Work findById(Long id) {
        Optional<Work> result = repository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
    }

    public Work save(Work work) {
        return repository.save(work);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Trabalho não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }
}
