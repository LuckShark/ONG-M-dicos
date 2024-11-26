package com.example.lucasigor.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @NotNull(message = "Insira uma data inicial válida")
    private Date startDate;

    @NotNull(message = "Insira uma data final válida")
    private Date endDate;

    @OneToMany(mappedBy = "voluntWork", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Volunteer> volunteers = new ArrayList<>();
}
