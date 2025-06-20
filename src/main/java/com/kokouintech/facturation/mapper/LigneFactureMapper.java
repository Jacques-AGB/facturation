package com.kokouintech.facturation.mapper;

import com.kokouintech.facturation.dto.LigneFactureDto;
import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.models.LigneFacture;

public class LigneFactureMapper {

    public static LigneFacture toLigneFacture(LigneFactureDto dto, Facture facture){
        LigneFacture ligneFacture = new LigneFacture();
        ligneFacture.setDescription(dto.description());
        ligneFacture.setQuantite(dto.quantite());
        ligneFacture.setPrixUnitaireHT(dto.prixUnitaireHT());
        ligneFacture.setTauxTVA(dto.tauxTVA());
        ligneFacture.setFacture(facture);
        return ligneFacture;
    }
}
