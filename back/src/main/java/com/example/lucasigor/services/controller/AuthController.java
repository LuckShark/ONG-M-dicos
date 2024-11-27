package com.example.lucasigor.services.controller;

import com.example.lucasigor.dto.LoginDTO;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Login", description = "Endpoint para realizar login de voluntários")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Volunteer> login(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            Volunteer volunteer = authService.authenticate(loginDTO);
            return ResponseEntity.ok(volunteer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}
