package com.example.lucasigor.controller;

import com.example.lucasigor.entities.VoluntWorkEnrollment;
import com.example.lucasigor.services.VoluntWorkEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class VoluntWorkEnrollmentController {

    @Autowired
    private VoluntWorkEnrollmentService service;

    @GetMapping
    public ResponseEntity<List<VoluntWorkEnrollment>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/inscricao-{id}")
    public ResponseEntity<VoluntWorkEnrollment> findById(@PathVariable Long id)  {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<VoluntWorkEnrollment> create(@RequestBody VoluntWorkEnrollment enrollment) {
        return ResponseEntity.ok(service.save(enrollment));
    }

    @PutMapping("/atualiza-{id}")
    public ResponseEntity<VoluntWorkEnrollment> update(@PathVariable Long id, @RequestBody VoluntWorkEnrollment enrollment) {
        return ResponseEntity.ok(service.update(id, enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }




}
