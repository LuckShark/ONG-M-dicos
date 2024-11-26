package com.example.lucasigor.controller;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.services.VoluntWorkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
@Tag(name = "Trabalhos", description = "Endpoints para gerenciar os Trabalhos disponíveis")
public class VoluntWorkController {

    @Autowired
    private VoluntWorkService voluntWorkService;

    @GetMapping
    @Operation(summary = "Lista todos os trabalhos")
    public List<VoluntWork> findAll() {
        return voluntWorkService.findAll();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Pesquisa um trabalho pelo ID")
    public VoluntWork findById(@PathVariable Long id) {
        return voluntWorkService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar Trabalho", description = "Cria um novo trabalho")
    public VoluntWork create(@Valid @RequestBody VoluntWork voluntWork) {
        return voluntWorkService.save(voluntWork);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Excluir trabalho", description = "Exclui um trabalho pelo Id")
    public ResponseEntity<Void> deleteVoluntWork(@PathVariable Long id) {
        voluntWorkService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
