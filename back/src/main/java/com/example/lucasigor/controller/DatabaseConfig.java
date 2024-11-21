package com.example.lucasigor.controller;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VoluntWorkRepository;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfig {

    private final VoluntWorkRepository voluntWorkRepository;
    private final VolunteerRepository volunteerRepository;

    public DatabaseConfig(VoluntWorkRepository voluntWorkRepository, VolunteerRepository volunteerRepository) {
        this.voluntWorkRepository = voluntWorkRepository;
        this.volunteerRepository = volunteerRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            VoluntWork voluntWork1 = new VoluntWork();
            voluntWork1.setServiceName("Nome do Serviço 1");
            voluntWork1.setDescription("Descrição do Serviço 1");
            voluntWork1.setInstituicaoSaude("Instituição de Saúde 1");

            VoluntWork voluntWork2 = new VoluntWork();
            voluntWork2.setServiceName("Nome do Serviço 2");
            voluntWork2.setDescription("Descrição do Serviço 2");
            voluntWork2.setInstituicaoSaude("Instituição de Saúde 2");

            voluntWorkRepository.save(voluntWork1);
            voluntWorkRepository.save(voluntWork2);

            Volunteer volunteer1 = new Volunteer();
            volunteer1.setService(voluntWork1);
            volunteer1.setName("Maria");
            volunteer1.setEmail("maria@gmail.com");
            volunteer1.setCpf("12345678901");
            volunteer1.setMatricula("20230001");
            volunteer1.setInstituicaoEnsino("Instituição de Ensino A");

            Volunteer volunteer2 = new Volunteer();
            volunteer2.setService(voluntWork1);
            volunteer2.setName("Bob");
            volunteer2.setEmail("bob@gmail.com");
            volunteer2.setCpf("98765432100");
            volunteer2.setMatricula("20230002");
            volunteer2.setInstituicaoEnsino("Instituição de Ensino B");

            Volunteer volunteer3 = new Volunteer();
            volunteer3.setService(voluntWork2);
            volunteer3.setName("Alex");
            volunteer3.setEmail("alex@gmail.com");
            volunteer3.setCpf("45678912300");
            volunteer3.setMatricula("20230003");
            volunteer3.setInstituicaoEnsino("Instituição de Ensino C");

            Volunteer volunteer4 = new Volunteer();
            volunteer4.setService(voluntWork2);
            volunteer4.setName("Ana");
            volunteer4.setEmail("ana@gmail.com");
            volunteer4.setCpf("78912345600");
            volunteer4.setMatricula("20230004");
            volunteer4.setInstituicaoEnsino("Instituição de Ensino D");

            volunteerRepository.save(volunteer1);
            volunteerRepository.save(volunteer2);
            volunteerRepository.save(volunteer3);
            volunteerRepository.save(volunteer4);
        };
    }
}