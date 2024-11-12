package com.example.lucasigor.repositories;

import com.example.lucasigor.entities.Service;
import com.example.lucasigor.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
