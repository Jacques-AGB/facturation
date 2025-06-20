package com.kokouintech.facturation.dto;

import com.kokouintech.facturation.models.TauxTVA;

public record LigneFactureDto(
        String description,
        Integer quantite,
        Double prixUnitaireHT,
        TauxTVA tauxTVA,
        Long factureId
) {}
