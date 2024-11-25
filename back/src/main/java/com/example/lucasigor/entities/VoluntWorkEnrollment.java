package com.example.lucasigor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tb_volunt_work_enrollment")
public class VoluntWorkEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id", nullable = false)
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "volunt_work_id", nullable = false)
    private VoluntWork voluntWork;

    @NotNull(message = "O número de vagas é obrigatório")
    private Integer vagas;

    @NotNull(message = "Insira uma data inicial válida")
    private Date startDate;

    @NotNull(message = "Insira uma data final válida")
    private Date endDate;

    public VoluntWorkEnrollment() {
    }

    public VoluntWorkEnrollment(Long id, Volunteer volunteer, VoluntWork voluntWork, Integer vagas, Date startDate, Date endDate) {
        this.id = id;
        this.volunteer = volunteer;
        this.voluntWork = voluntWork;
        this.vagas = vagas;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //GETTERs & SETTERs

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public VoluntWork getVoluntWork() {
        return voluntWork;
    }

    public void setVoluntWork(VoluntWork voluntWork) {
        this.voluntWork = voluntWork;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
