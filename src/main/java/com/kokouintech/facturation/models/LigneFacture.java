package com.kokouintech.facturation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String description;
    @Positive
    private Integer quantite;
    @Positive
    private Double prixUnitaireHT;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TauxTVA tauxTVA;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "facture_id", nullable = false)
    private Facture facture;
}
