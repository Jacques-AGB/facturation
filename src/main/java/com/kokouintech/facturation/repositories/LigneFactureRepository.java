package com.kokouintech.facturation.repositories;

import com.kokouintech.facturation.models.Facture;
import com.kokouintech.facturation.models.LigneFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneFactureRepository extends JpaRepository<LigneFacture, Long> {
    public List<LigneFacture> findByFactureId(Long id);
}
