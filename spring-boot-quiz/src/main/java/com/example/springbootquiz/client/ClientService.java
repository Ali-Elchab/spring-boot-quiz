package com.example.springbootquiz.client;

import java.util.List;
import java.util.Optional;

import com.example.springbootquiz.client.Client;
import com.example.springbootquiz.client.ClientRepository;
import com.example.springbootquiz.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientById(client.getId());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("client already exists");
        }
        clientRepository.save(client);
    }


    @Transactional
    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(updatedClient.getName());
            existingClient.setLast_name(updatedClient.getLast_name());
            existingClient.setMobile(updatedClient.getMobile());

            return clientRepository.save(existingClient);
        } else {
            throw new IllegalArgumentException("Client with id " + id + " not found");
        }
    }

}
