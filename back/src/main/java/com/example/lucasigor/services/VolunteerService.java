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

    //PUT - Update volunteer
    public Volunteer update(Long id, Volunteer updatedVolunteer) {
        Volunteer existingVolunteer = volunteerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado com id: " + id));

        existingVolunteer.setName(updatedVolunteer.getName());
        existingVolunteer.setEmail(updatedVolunteer.getEmail());
        existingVolunteer.setCpf(updatedVolunteer.getCpf());
        existingVolunteer.setMatricula(updatedVolunteer.getMatricula());
        existingVolunteer.setInstituicaoEnsino(updatedVolunteer.getInstituicaoEnsino());
        existingVolunteer.setService(updatedVolunteer.getService());

        return volunteerRepository.save(existingVolunteer);
    }


}
