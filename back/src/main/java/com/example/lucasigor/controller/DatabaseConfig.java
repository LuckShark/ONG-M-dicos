package com.example.lucasigor.controller;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.entities.VoluntWorkEnrollment;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VoluntWorkEnrollmentRepository;
import com.example.lucasigor.repositories.VoluntWorkRepository;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Configuration
public class DatabaseConfig {

    private final VoluntWorkRepository voluntWorkRepository;
    private final VolunteerRepository volunteerRepository;
    private final VoluntWorkEnrollmentRepository voluntWorkEnrollmentRepository;

    public DatabaseConfig(VoluntWorkRepository voluntWorkRepository, VolunteerRepository volunteerRepository,
                          VoluntWorkEnrollmentRepository voluntWorkEnrollmentRepository) {
        this.voluntWorkRepository = voluntWorkRepository;
        this.volunteerRepository = volunteerRepository;
        this.voluntWorkEnrollmentRepository = voluntWorkEnrollmentRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {

            // Negócio pra ajeitar a data

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            //TRABALHOS VOLUNTÁRIOS

            VoluntWork voluntWork1 = new VoluntWork();
            voluntWork1.setServiceName("Apoio da Campanha de Vaciação");
            voluntWork1.setDescription("Auxiliar no registro e organização durante a campanha");
            voluntWork1.setInstituicaoSaude("Hospital Público da UFC");
            voluntWork1.setVagas(5);

            VoluntWork voluntWork2 = new VoluntWork();
            voluntWork2.setServiceName("Atendimento em Clínica");
            voluntWork2.setDescription("Realizar triagem e organização em eventos em clínica comunitária");
            voluntWork2.setInstituicaoSaude("Clínica Comunitária do Bairro do Igor");
            voluntWork2.setVagas(3);

            voluntWorkRepository.save(voluntWork1);
            voluntWorkRepository.save(voluntWork2);

            //VOLUNTÁRIOS (internos)

            Volunteer volunteer1 = new Volunteer();
            volunteer1.setService(voluntWork1);
            volunteer1.setName("Maria");
            volunteer1.setEmail("maria@gmail.com");
            volunteer1.setCpf("12345678901");
            volunteer1.setMatricula("20230001");
            volunteer1.setPassword("1234567");
            volunteer1.setInstituicaoEnsino("Instituição de Ensino A");

            Volunteer volunteer2 = new Volunteer();
            volunteer2.setService(voluntWork1);
            volunteer2.setName("Bob");
            volunteer2.setEmail("bob@gmail.com");
            volunteer2.setCpf("98765432100");
            volunteer2.setMatricula("20230002");
            volunteer2.setInstituicaoEnsino("Instituição de Ensino B");
            volunteer2.setPassword("1234567");

            Volunteer volunteer3 = new Volunteer();
            volunteer3.setService(voluntWork2);
            volunteer3.setName("Alex");
            volunteer3.setEmail("alex@gmail.com");
            volunteer3.setCpf("45678912300");
            volunteer3.setMatricula("20230003");
            volunteer3.setInstituicaoEnsino("Instituição de Ensino C");
            volunteer3.setPassword("1234567");

            Volunteer volunteer4 = new Volunteer();
            volunteer4.setService(voluntWork2);
            volunteer4.setName("Ana");
            volunteer4.setEmail("ana@gmail.com");
            volunteer4.setCpf("78912345600");
            volunteer4.setMatricula("20230004");
            volunteer4.setInstituicaoEnsino("Instituição de Ensino D");
            volunteer4.setPassword("1234567");

            volunteerRepository.save(volunteer1);
            volunteerRepository.save(volunteer2);
            volunteerRepository.save(volunteer3);
            volunteerRepository.save(volunteer4);

            //INSCRIÇÕES (VoluntWorkEnrollment)

            Date startDate1 = dateFormat.parse("2024-10-12");
            Date endDate1 = dateFormat.parse("2024-11-12");

            List<Volunteer> volunteers = new ArrayList<>();
            volunteers.add(volunteer1);
            volunteers.add(volunteer2);
            volunteers.add(volunteer3);

            VoluntWorkEnrollment enrollment1 = new VoluntWorkEnrollment();
            enrollment1.setVoluntWork(voluntWork1);
            enrollment1.setVolunteers(volunteers);
            enrollment1.setStartDate(startDate1);
            enrollment1.setEndDate(endDate1);

            voluntWorkEnrollmentRepository.save(enrollment1);

            Date startDate2 = dateFormat.parse("2024-12-01");
            Date endDate2 = dateFormat.parse("2025-01-15");


            VoluntWorkEnrollment enrollment2 = new VoluntWorkEnrollment();
            enrollment2.setVoluntWork(voluntWork2);
            enrollment2.setVolunteers(volunteers);
            enrollment2.setStartDate(startDate2);
            enrollment2.setEndDate(endDate2);


            voluntWorkEnrollmentRepository.save(enrollment2);

        };
    }
}