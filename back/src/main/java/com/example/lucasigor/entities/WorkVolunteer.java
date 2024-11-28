package com.example.lucasigor.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_work_volunteer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkVolunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_id", nullable = false)
    @JsonIgnoreProperties("workVolunteers")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "volunteer_id", nullable = false)
    @JsonIgnoreProperties("workVolunteers")
    private Volunteer volunteer;
}