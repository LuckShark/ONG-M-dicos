package com.example.lucasigor.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String description;

    private String instituicaoSaude;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstituicaoSaude() {
        return instituicaoSaude;
    }

    public void setInstituicaoSaude(String instituicaoSaude) {
        this.instituicaoSaude = instituicaoSaude;
    }
}
