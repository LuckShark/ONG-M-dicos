package com.example.lucasigor.controller;

import com.example.lucasigor.dto.SubscribeRequest;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.entities.Work;
import com.example.lucasigor.entities.WorkVolunteer;
import com.example.lucasigor.repositories.VolunteerRepository;
import com.example.lucasigor.repositories.WorkRepository;
import com.example.lucasigor.repositories.WorkVolunteerRepository;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/work-volunteers")
public class WorkVolunteerController {

    @Autowired
    private WorkVolunteerRepository workVolunteerRepository;

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribeToWork(@RequestBody SubscribeRequest request) {
        Optional<Work> work = workRepository.findById(request.getWorkId());
        Optional<Volunteer> volunteer = volunteerRepository.findById(request.getVolunteerId());

        if (work.isEmpty() || volunteer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabalho ou voluntário não encontrado.");
        }

        work.get().setVagasOcupadas(work.get().getWorkVolunteers().size());

        if (work.get().getVagasOcupadas() >= work.get().getVagas()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vagas esgotadas.");
        }

        if (workVolunteerRepository.existsByWorkIdAndVolunteerId(request.getWorkId(), request.getVolunteerId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você já está inscrito nesse trabalho.");
        }

        WorkVolunteer workVolunteer = new WorkVolunteer();
        workVolunteer.setWork(work.get());
        workVolunteer.setVolunteer(volunteer.get());
        workVolunteerRepository.save(workVolunteer);

        return ResponseEntity.ok(work);
    }
}
