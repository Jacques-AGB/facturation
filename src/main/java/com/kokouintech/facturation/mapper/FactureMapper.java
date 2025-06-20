package com.kokouintech.facturation.mapper;

import com.kokouintech.facturation.dto.FactureDto;
import com.kokouintech.facturation.models.Client;
import com.kokouintech.facturation.models.Facture;

import java.time.LocalDate;

public class FactureMapper {

    public static Facture toFacture(FactureDto dto, Client client){
        Facture facture = new Facture();
        facture.setDate(LocalDate.now());
        facture.setClient(client);
        facture.setReference(dto.reference());
        return facture;
    }





}
