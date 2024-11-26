package com.example.lucasigor.configuration;

import com.example.lucasigor.entities.VoluntWork;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.repositories.VoluntWorkRepository;
import com.example.lucasigor.repositories.VolunteerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;

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
            // Negócio pra ajeitar a data

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            //TRABALHOS VOLUNTÁRIOS

            VoluntWork voluntWork1 = new VoluntWork();
            voluntWork1.setServiceName("Apoio da Campanha de Vaciação");
            voluntWork1.setDescription("Auxiliar no registro e organização durante a campanha");
            voluntWork1.setInstituicaoSaude("Hospital Público da UFC");
            voluntWork1.setVagas(5);
            voluntWork1.setStartDate(dateFormat.parse("2024-10-12"));
            voluntWork1.setEndDate(dateFormat.parse("2024-11-12"));

            VoluntWork voluntWork2 = new VoluntWork();
            voluntWork2.setServiceName("Atendimento em Clínica");
            voluntWork2.setDescription("Realizar triagem e organização em eventos em clínica comunitária");
            voluntWork2.setInstituicaoSaude("Clínica Comunitária do Bairro do Igor");
            voluntWork2.setVagas(3);
            voluntWork2.setStartDate(dateFormat.parse("2024-12-01"));
            voluntWork2.setEndDate(dateFormat.parse("2025-01-15"));

            voluntWorkRepository.save(voluntWork1);
            voluntWorkRepository.save(voluntWork2);

            //VOLUNTÁRIOS (internos)

            Volunteer volunteer1 = new Volunteer();
            volunteer1.setName("Maria");
            volunteer1.setEmail("maria@gmail.com");
            volunteer1.setCpf("12345678901");
            volunteer1.setMatricula("20230001");
            volunteer1.setPassword("1234567");
            volunteer1.setInstituicaoEnsino("Instituição de Ensino A");
            volunteer1.setVoluntWork(voluntWork1);

            Volunteer volunteer2 = new Volunteer();
            volunteer2.setName("Bob");
            volunteer2.setEmail("bob@gmail.com");
            volunteer2.setCpf("98765432100");
            volunteer2.setMatricula("20230002");
            volunteer2.setInstituicaoEnsino("Instituição de Ensino B");
            volunteer2.setPassword("1234567");
            volunteer2.setVoluntWork(voluntWork1);

            Volunteer volunteer3 = new Volunteer();
            volunteer3.setName("Alex");
            volunteer3.setEmail("alex@gmail.com");
            volunteer3.setCpf("45678912300");
            volunteer3.setMatricula("20230003");
            volunteer3.setInstituicaoEnsino("Instituição de Ensino C");
            volunteer3.setPassword("1234567");
            volunteer3.setVoluntWork(voluntWork2);

            Volunteer volunteer4 = new Volunteer();
            volunteer4.setName("Ana");
            volunteer4.setEmail("ana@gmail.com");
            volunteer4.setCpf("78912345600");
            volunteer4.setMatricula("20230004");
            volunteer4.setInstituicaoEnsino("Instituição de Ensino D");
            volunteer4.setPassword("1234567");
            volunteer4.setVoluntWork(voluntWork2);

            volunteerRepository.save(volunteer1);
            volunteerRepository.save(volunteer2);
            volunteerRepository.save(volunteer3);
            volunteerRepository.save(volunteer4);

            voluntWork1.setVolunteers(List.of(volunteer1, volunteer2));
            voluntWork2.setVolunteers(List.of(volunteer3, volunteer4));

            voluntWorkRepository.save(voluntWork1);
            voluntWorkRepository.save(voluntWork2);
        };
    }
}