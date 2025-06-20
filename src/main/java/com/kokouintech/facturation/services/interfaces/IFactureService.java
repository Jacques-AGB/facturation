package com.kokouintech.facturation.services.interfaces;

import com.kokouintech.facturation.dto.FactureDto;
import com.kokouintech.facturation.models.Facture;

import java.util.List;

public interface IFactureService {
    public String createFacture(FactureDto clientDto);
    public List<Facture> getFactures();
    public Facture getFacture(Long facture);
}
