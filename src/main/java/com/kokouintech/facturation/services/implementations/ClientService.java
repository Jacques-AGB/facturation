package com.kokouintech.facturation.services.implementations;

import com.kokouintech.facturation.Mapper.ClientMapper;
import com.kokouintech.facturation.dto.ClientDto;
import com.kokouintech.facturation.models.Client;
import com.kokouintech.facturation.repositories.ClientRepository;
import com.kokouintech.facturation.services.interfaces.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    public final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public String createClient(ClientDto clientDto) {
        System.out.println(clientDto);
        Optional<Client> existingClient = clientRepository.findByEmail(clientDto.getEmail());
        if(existingClient.isPresent())
        {
            throw new RuntimeException("Le client avec id "+existingClient.get().getId()+ "existe déjà");
        }
        Client client = ClientMapper.toClient(clientDto);
        clientRepository.save(client);
        return "Le Client "+ client.getId() +"a été Créé avec succès";
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le client avec l'id" + id + "n'existe pas"));
    }
}
