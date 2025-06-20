package com.kokouintech.facturation.Controllers;

import com.kokouintech.facturation.dto.ClientDto;
import com.kokouintech.facturation.models.Client;
import com.kokouintech.facturation.services.implementations.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientService.createClient(clientDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
            Client client = clientService.getClient(id);
            return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
            List<Client> clients = clientService.getClients();
            return ResponseEntity.ok(clients);

    }
}
