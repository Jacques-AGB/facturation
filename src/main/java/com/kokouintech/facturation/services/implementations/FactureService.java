package com.kokouintech.facturation.services.implementations;

import com.itextpdf.text.Document;
import com.kokouintech.facturation.Mapper.FactureMapper;
import com.kokouintech.facturation.dto.FactureDto;
import com.kokouintech.facturation.models.Client;
import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.repositories.ClientRepository;
import com.kokouintech.facturation.repositories.FactureRepository;
import com.kokouintech.facturation.services.interfaces.IFactureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService implements IFactureService {
   private final FactureRepository factureRepository;
   private final ClientRepository clientRepository;

    public FactureService(FactureRepository factureRepository, ClientRepository clientRepository) {
        this.factureRepository = factureRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public String createFacture(FactureDto factureDto) {
        Optional<Facture> existingFacture = factureRepository.findByReference(factureDto.getReference());
        if(existingFacture.isPresent())
        {
            throw new RuntimeException("Le facture avec id "+existingFacture.get().getId()+ "existe déjà");
        }
        Client client = clientRepository.findById(factureDto.getClientId()).orElseThrow(() ->new RuntimeException ("Client non trouvé"));
        Facture facture = FactureMapper.toFacture(factureDto, client);
        factureRepository.save(facture);
        return "Le Facture "+ facture.getId() +"a été Créé avec succès";
    }

    @Override
    public List<Facture> getFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture getFacture(Long id) {
        return factureRepository.findById(id).orElseThrow(() ->new RuntimeException ("Facture non trouvé"));
    }
}
