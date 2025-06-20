package com.kokouintech.facturation.dto;

import com.kokouintech.facturation.models.TauxTVA;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LigneFactureDto {

    private String description;
    private Integer quantite;
    private Double prixUnitaireHT;
    private TauxTVA tauxTVA;
    private Long factureId ;
}
