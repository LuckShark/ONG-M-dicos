package com.example.lucasigor.services;

import com.example.lucasigor.dto.LoginDTO;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public Volunteer authenticate(LoginDTO loginDTO) {
        Volunteer volunteer = volunteerRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email ou senha inválidos"));

        if (!volunteer.getPassword().equals(loginDTO.getPassword())) {
            throw new IllegalArgumentException("Email ou senha inválidos");
        }

        return volunteer;
    }
}
