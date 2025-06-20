package com.kokouintech.facturation.Mapper;

import com.kokouintech.facturation.dto.ClientDto;
import com.kokouintech.facturation.models.Client;

import java.time.LocalDate;

public class ClientMapper {

    public static Client toClient(ClientDto dto){
        Client client = new Client();
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        client.setSiret(dto.getSiret());
        client.setDateCreation(LocalDate.now());
        return client;
    }
}
