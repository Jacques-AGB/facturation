package com.kokouintech.facturation.services.implementations;

import com.kokouintech.facturation.Mapper.FactureMapper;
import com.kokouintech.facturation.Mapper.LigneFactureMapper;
import com.kokouintech.facturation.dto.FactureDto;
import com.kokouintech.facturation.dto.LigneFactureDto;
import com.kokouintech.facturation.models.Client;
import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.models.LigneFacture;
import com.kokouintech.facturation.repositories.ClientRepository;
import com.kokouintech.facturation.repositories.FactureRepository;
import com.kokouintech.facturation.repositories.LigneFactureRepository;
import com.kokouintech.facturation.services.interfaces.ILigneFactureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneFactureService implements ILigneFactureService {
    private final FactureRepository factureRepository;
    private final LigneFactureRepository ligneFactureRepository;

    public LigneFactureService(FactureRepository factureRepository, LigneFactureRepository ligneFactureRepository) {
        this.factureRepository = factureRepository;
        this.ligneFactureRepository = ligneFactureRepository;
    }

    @Override
    public String createLigneFacture(LigneFactureDto ligneFactureDto) {

        Facture facture = factureRepository.findById(ligneFactureDto.getFactureId()).orElseThrow(() ->new RuntimeException ("Facture non trouvé"));
        LigneFacture ligneFacture = LigneFactureMapper.toLigneFacture(ligneFactureDto, facture);
        ligneFactureRepository.save(ligneFacture);

        List<LigneFacture> lignes = ligneFactureRepository.findByFactureId(facture.getId());
        double totalHT = 0;
        double totalTVA = 0;

        for (LigneFacture ligneFacture1: lignes){
            double sousTotalHT = ligneFacture1.getQuantite()*ligneFacture1.getPrixUnitaireHT();
            totalHT+=sousTotalHT;

            double taux = ligneFacture1.getTauxTVA().getValeur();
            totalTVA +=sousTotalHT * taux/100;
        }

        double totalTTC = totalHT + totalTVA;

        facture.setTotalHT((totalHT));
        facture.setTotalTVA((totalTVA));
        facture.setTotalTTC((totalTTC));
        factureRepository.save(facture);

        return "La ligne "+ facture.getId() +"a été Créé avec succès";
    }

    @Override
    public List<LigneFacture> getLigneFactures() {
        return ligneFactureRepository.findAll();
    }

    @Override
    public LigneFacture getLigneFacture(Long id) {
        return ligneFactureRepository.findById(id).orElseThrow(() ->new RuntimeException ("Ligne facture non trouvé"));
    }
}
