package com.example.lucasigor.configuration;

import com.example.lucasigor.entities.Work;
import com.example.lucasigor.entities.Volunteer;
import com.example.lucasigor.entities.WorkVolunteer;
import com.example.lucasigor.repositories.WorkRepository;
import com.example.lucasigor.repositories.VolunteerRepository;
import com.example.lucasigor.repositories.WorkVolunteerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class DatabaseConfig {

    private final WorkRepository workRepository;
    private final VolunteerRepository volunteerRepository;
    private final WorkVolunteerRepository workVolunteerRepository;

    public DatabaseConfig(WorkRepository workRepository, VolunteerRepository volunteerRepository, WorkVolunteerRepository workVolunteerRepository) {
        this.workRepository = workRepository;
        this.volunteerRepository = volunteerRepository;
        this.workVolunteerRepository = workVolunteerRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // TRABALHOS VOLUNTÁRIOS
            Work work1 = new Work();
            work1.setServiceName("Apoio da Campanha de Vacinação");
            work1.setDescription("Auxiliar no registro e organização durante a campanha");
            work1.setInstituicaoSaude("Hospital Público da UFC");
            work1.setVagas(5);
            work1.setStartDate(dateFormat.parse("2024-10-12"));
            work1.setEndDate(dateFormat.parse("2024-11-12"));

            Work work2 = new Work();
            work2.setServiceName("Atendimento em Clínica");
            work2.setDescription("Realizar triagem e organização em eventos em clínica comunitária");
            work2.setInstituicaoSaude("Clínica Comunitária do Bairro do Igor");
            work2.setVagas(3);
            work2.setStartDate(dateFormat.parse("2024-12-01"));
            work2.setEndDate(dateFormat.parse("2025-01-15"));

            workRepository.save(work1);
            workRepository.save(work2);

            // VOLUNTÁRIOS
            Volunteer volunteer1 = new Volunteer();
            volunteer1.setName("Maria");
            volunteer1.setEmail("maria@gmail.com");
            volunteer1.setCpf("12345678901");
            volunteer1.setMatricula("20230001");
            volunteer1.setPassword("1234567");
            volunteer1.setInstituicaoEnsino("Instituição de Ensino A");

            Volunteer volunteer2 = new Volunteer();
            volunteer2.setName("Bob");
            volunteer2.setEmail("bob@gmail.com");
            volunteer2.setCpf("98765432100");
            volunteer2.setMatricula("20230002");
            volunteer2.setInstituicaoEnsino("Instituição de Ensino B");
            volunteer2.setPassword("1234567");

            Volunteer volunteer3 = new Volunteer();
            volunteer3.setName("Alex");
            volunteer3.setEmail("alex@gmail.com");
            volunteer3.setCpf("45678912300");
            volunteer3.setMatricula("20230003");
            volunteer3.setInstituicaoEnsino("Instituição de Ensino C");
            volunteer3.setPassword("1234567");

            Volunteer volunteer4 = new Volunteer();
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

            // ASSOCIAÇÕES WORK-VOLUNTEER
            WorkVolunteer workVolunteer1 = new WorkVolunteer();
            workVolunteer1.setWork(work1);
            workVolunteer1.setVolunteer(volunteer1);

            WorkVolunteer workVolunteer2 = new WorkVolunteer();
            workVolunteer2.setWork(work1);
            workVolunteer2.setVolunteer(volunteer2);

            WorkVolunteer workVolunteer3 = new WorkVolunteer();
            workVolunteer3.setWork(work2);
            workVolunteer3.setVolunteer(volunteer3);

            WorkVolunteer workVolunteer4 = new WorkVolunteer();
            workVolunteer4.setWork(work2);
            workVolunteer4.setVolunteer(volunteer4);

            workVolunteerRepository.save(workVolunteer1);
            workVolunteerRepository.save(workVolunteer2);
            workVolunteerRepository.save(workVolunteer3);
            workVolunteerRepository.save(workVolunteer4);
        };
    }
}