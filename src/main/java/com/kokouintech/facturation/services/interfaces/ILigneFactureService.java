package com.kokouintech.facturation.services.interfaces;

import com.kokouintech.facturation.dto.LigneFactureDto;
import com.kokouintech.facturation.models.LigneFacture;

import java.util.List;

public interface ILigneFactureService {

    public String createLigneFacture(LigneFactureDto ligneFactureDto) ;
    public List<LigneFacture> getLigneFactures();
    public LigneFacture getLigneFacture(Long id) ;
}
