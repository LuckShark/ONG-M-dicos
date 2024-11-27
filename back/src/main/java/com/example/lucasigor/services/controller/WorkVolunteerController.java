package com.example.lucasigor.services.controller;

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
        Optional<Work> workOptional = workRepository.findById(request.getWorkId());
        Optional<Volunteer> volunteerOptional = volunteerRepository.findById(request.getVolunteerId());

        if (workOptional.isEmpty() || volunteerOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabalho ou voluntário não encontrado.");
        }

        if (workVolunteerRepository.existsByWorkIdAndVolunteerId(request.getWorkId(), request.getVolunteerId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você já está inscrito nesse trabalho.");
        }

        WorkVolunteer workVolunteer = new WorkVolunteer();
        workVolunteer.setWork(workOptional.get());
        workVolunteer.setVolunteer(volunteerOptional.get());
        workVolunteerRepository.save(workVolunteer);

        //Ele fica dando uns erros com JSON então tive que retornar um objeto JSON com a mensagem de sucesso
        return ResponseEntity.ok(new ApiResponse("Inscrição realizada com sucesso"));
    }

    //Mais uma porra só pra encapsular a mensagem de resposta
    public static class ApiResponse {
        private String message;

        public ApiResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
