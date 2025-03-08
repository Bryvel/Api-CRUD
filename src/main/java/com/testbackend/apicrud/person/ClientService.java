package com.testbackend.apicrud.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public ResponseEntity<Object> newClient(Client client) {
        clientRepository.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getClientByIdentificacion(int idendtificacion) {
        Optional<Client> clientOptional = clientRepository.findById(idendtificacion);
        if (!clientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Client existingClient = clientOptional.get();
        return ResponseEntity.ok(existingClient);
    }

    public ResponseEntity<Object> deleteClientByIdentificacion(int idendtificacion) {
        Optional<Client> clientOptional = clientRepository.findById(idendtificacion);
        if (!clientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(idendtificacion);
        return null;
    }

    public ResponseEntity<Object> updateClientByIdentificacion(int identificacion, Client updateClient) {
        Optional<Client> clientOptional = clientRepository.findById(identificacion);
        if (!clientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Client existingClient = clientOptional.get();

        existingClient.setDireccion(updateClient.getDireccion());
        existingClient.setNombre(updateClient.getNombre());
        existingClient.setClientId(updateClient.getClientId());
        existingClient.setEstado(updateClient.getEstado());
        existingClient.setTelefono(updateClient.getTelefono());
        existingClient.setGenero(updateClient.getGenero());
        existingClient.setDireccion(updateClient.getDireccion());
        existingClient.setEdad(updateClient.getEdad());
        existingClient.setPassword(updateClient.getPassword());

        clientRepository.save(updateClient);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
