package com.example.lucasigor.repositories;

import com.example.lucasigor.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
