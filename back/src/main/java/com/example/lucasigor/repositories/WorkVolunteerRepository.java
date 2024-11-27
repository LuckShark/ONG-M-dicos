package com.example.lucasigor.repositories;

import com.example.lucasigor.entities.Work;
import com.example.lucasigor.entities.WorkVolunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkVolunteerRepository extends JpaRepository<WorkVolunteer, Long> {
    boolean existsByWorkIdAndVolunteerId(Long workId, Long volunteerId);
    //Colocar esse método aqui pra ver se um voluntário já está inscrito em um trabalho
}
