package com.example.lucasigor.controller;


import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import com.example.lucasigor.services.VolunteerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/volunteers")
@Tag(name = "Volunteers", description = "Endpoints para gerenciar Voluntários")
public class VolunteerController {

    //Injeção de dependencia
    //@Autowired
    //private VolunteerRepository repository; AGORA VAMOS USAR O SERVICE

    @Autowired
    private VolunteerService volunteerService;

    @GetMapping
    public List<Volunteer> findAll() {
        return volunteerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Volunteer findById(@PathVariable Long id) {
        return volunteerService.findById(id);
    }
    @PostMapping
    @Operation(summary = "Cadastrar Voluntário", description = "Cria um novo voluntário")
    public Volunteer create(@Valid @RequestBody Volunteer volunteer) {
        return volunteerService.save(volunteer);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Atualizar voluntário", description = "Atualiza os dados de um voluntário existente")
    public ResponseEntity<Volunteer> updateVolunteer(
            @PathVariable Long id,
            @Valid @RequestBody Volunteer volunteer) {
        Volunteer updatedVolunteer = volunteerService.update(id, volunteer);
        return ResponseEntity.ok(updatedVolunteer);
    }
}
