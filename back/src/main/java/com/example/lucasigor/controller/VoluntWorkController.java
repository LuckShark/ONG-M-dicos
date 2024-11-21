package com.example.lucasigor.controller;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.services.VoluntWorkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
