package com.kokouintech.facturation.services.interfaces;

import com.kokouintech.facturation.dto.ClientDto;
import com.kokouintech.facturation.models.Client;

import java.util.List;

public interface IClientService {
    public String createClient(ClientDto clientDto);
    public List<Client> getClients();
    public Client getClient(Long id);
}
