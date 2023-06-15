package com.proyecto.controllers;

import com.proyecto.model.Cliente;
import com.proyecto.services.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteId) {

        Optional<Cliente> clienteDb = clienteService.obtenCliente(clienteId);

        if (clienteDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente especificado no existe.");
        }

        return ResponseEntity.ok(clienteDb.get());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.obtenClientes());
    }

    @PostMapping
    public ResponseEntity<Void> creaCliente(@Valid @RequestBody Cliente cliente) {
        Cliente clienteNuevo = clienteService.guardaCliente(cliente);

        return ResponseEntity.created(URI.create(String.valueOf(clienteNuevo.getId()))).build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Void> actualizaCliente(@PathVariable Long clienteId, @RequestBody @Valid Cliente cliente) {

        clienteService.actualizaCliente(cliente);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminaCliente(@PathVariable Long clienteId) {
        clienteService.eliminaCliente(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}