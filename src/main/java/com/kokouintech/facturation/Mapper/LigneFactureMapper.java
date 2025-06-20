package com.kokouintech.facturation.Mapper;

import com.kokouintech.facturation.dto.LigneFactureDto;
import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.models.LigneFacture;

public class LigneFactureMapper {

    public static LigneFacture toLigneFacture(LigneFactureDto dto, Facture facture){
        LigneFacture ligneFacture = new LigneFacture();
        ligneFacture.setDescription(dto.getDescription());
        ligneFacture.setQuantite(dto.getQuantite());
        ligneFacture.setPrixUnitaireHT(dto.getPrixUnitaireHT());
        ligneFacture.setTauxTVA(dto.getTauxTVA());
        ligneFacture.setFacture(facture);
        return ligneFacture;
    }
}
