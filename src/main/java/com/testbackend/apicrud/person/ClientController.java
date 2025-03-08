package com.testbackend.apicrud.person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Object> createClient(@RequestBody Client client) {
        return clientService.newClient(client);
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<Object> updateClientByIdentificacion(@PathVariable Integer identificacion, @RequestBody Client client) {
        return clientService.updateClientByIdentificacion(identificacion, client);

    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Object> deleteClientByIdentificacion(@PathVariable Integer identificacion) {
        return clientService.deleteClientByIdentificacion(identificacion);

    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<Object> getClientByIdentificacion(@PathVariable Integer identificacion) {
        return clientService.getClientByIdentificacion(identificacion);

    }

}
