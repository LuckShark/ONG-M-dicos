package com.example.lucasigor.services.controller;

import com.example.lucasigor.entities.Work;
import com.example.lucasigor.services.WorkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/work")
@Tag(name = "Trabalhos", description = "Endpoints para gerenciar os Trabalhos disponíveis")
public class WorkController {

    @Autowired
    private WorkService service;

    @GetMapping
    @Operation(summary = "Lista todos os trabalhos")
    public List<Work> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Pesquisa um trabalho pelo ID")
    public Work findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar Trabalho", description = "Cria um novo trabalho")
    public Work create(@Valid @RequestBody Work work) {
        return service.save(work);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Excluir trabalho", description = "Exclui um trabalho pelo Id")
    public ResponseEntity<Void> deleteVoluntWork(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //ENDPOINTS para SE INCREVER no trabalho

}
