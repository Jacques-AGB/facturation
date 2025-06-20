package com.kokouintech.facturation.repositories;

import com.kokouintech.facturation.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Optional<Client> findByEmail(String email);
}
