package com.kokouintech.facturation.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank
    private String nom;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String siret;
    @NotNull
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Facture> factures;
}
