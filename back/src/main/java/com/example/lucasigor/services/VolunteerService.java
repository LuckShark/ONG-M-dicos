package com.example.lucasigor.services;

import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.exceptions.ResourceNotFoundException;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository repository;

    //GET ALL
    public List<Volunteer> findAll() {
        return repository.findAll();
    }

    //GET BY ID
    public Volunteer findById(Long id) {
        Optional<Volunteer> result = repository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Voluntário não encontrado"));
    }

    //POST - New volunteer
    public Volunteer save(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    //PUT - Update volunteer
    public Volunteer update(Long id, Volunteer updatedVolunteer) {
        Volunteer existingVolunteer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado com id: " + id));

        existingVolunteer.setName(updatedVolunteer.getName());
        existingVolunteer.setEmail(updatedVolunteer.getEmail());
        existingVolunteer.setCpf(updatedVolunteer.getCpf());
        existingVolunteer.setMatricula(updatedVolunteer.getMatricula());
        existingVolunteer.setInstituicaoEnsino(updatedVolunteer.getInstituicaoEnsino());

        return repository.save(existingVolunteer);
    }

    //DELETE - Excluir voluntário
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Voluntário não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }


}
