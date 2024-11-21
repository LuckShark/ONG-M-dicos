package com.example.lucasigor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @Email(message = "Formato de email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
    private String cpf;
    @NotBlank(message = "Matrícula é obrigatória")
    private String matricula;
    @NotBlank(message = "Instituição de Ensino é obrigatória")
    private String instituicaoEnsino;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private VoluntWork voluntWork;

    public Volunteer() {
    }

    public Volunteer(Long id, String name, String email, String cpf, String matricula, String instituicaoEnsino, VoluntWork voluntWork) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.matricula = matricula;
        this.instituicaoEnsino = instituicaoEnsino;
        this.voluntWork = voluntWork;
    }

    //GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public VoluntWork getService() {
        return voluntWork;
    }

    public void setService(VoluntWork voluntWork) {
        this.voluntWork = voluntWork;
    }
}
