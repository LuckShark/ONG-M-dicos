package com.example.lucasigor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_volunt_work_enrollment")
public class VoluntWorkEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunt_work_id", nullable = false)
    private VoluntWork voluntWork;

    @OneToMany(mappedBy = "voluntWorkEnrollment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Volunteer> volunteers = new ArrayList<>();

    @NotNull(message = "Insira uma data inicial válida")
    private Date startDate;

    @NotNull(message = "Insira uma data final válida")
    private Date endDate;

    public VoluntWorkEnrollment() {
    }

    public VoluntWorkEnrollment(Long id, VoluntWork voluntWork, List<Volunteer> volunteers, Date startDate, Date endDate) {
        this.id = id;
        this.voluntWork = voluntWork;
        this.volunteers = volunteers;
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

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public VoluntWork getVoluntWork() {
        return voluntWork;
    }

    public void setVoluntWork(VoluntWork voluntWork) {
        this.voluntWork = voluntWork;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoluntWorkEnrollment that = (VoluntWorkEnrollment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
