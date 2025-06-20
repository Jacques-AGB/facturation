package com.kokouintech.facturation.mapper;

import com.kokouintech.facturation.dto.ClientDto;
import com.kokouintech.facturation.models.Client;

import java.time.LocalDate;

public class ClientMapper {

    public static Client toClient(ClientDto dto){
        Client client = new Client();
        client.setNom(dto.nom());
        client.setEmail(dto.email());
        client.setSiret(dto.siret());
        client.setDateCreation(LocalDate.now());
        return client;
    }
}
