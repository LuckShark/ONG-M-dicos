package com.example.lucasigor.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_service")
public class VoluntWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do Serviço é obrigatório")
    private String serviceName;

    @NotBlank(message = "Descrição do Serviço é obrigatório")
    private String description;

    @NotBlank(message = "Instituição é obrigatória")
    private String instituicaoSaude;

    @NotNull(message = "O número de vagas é obrigatório")
    private Integer vagas;

    public VoluntWork() {
    }

    public VoluntWork(Long id, String serviceName, String description, String instituicaoSaude, Integer vagas) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.instituicaoSaude = instituicaoSaude;
        this.vagas = vagas;
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

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
