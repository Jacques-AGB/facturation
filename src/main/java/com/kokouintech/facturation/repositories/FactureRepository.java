package com.kokouintech.facturation.repositories;

import com.kokouintech.facturation.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    public Optional<Facture> findByReference(String reference);
}
