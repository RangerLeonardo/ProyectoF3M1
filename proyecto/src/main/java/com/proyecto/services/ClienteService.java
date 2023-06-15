package com.proyecto.services;


import com.proyecto.controllers.mappers.ClienteMapper;
import com.proyecto.model.Cliente;
import com.proyecto.persistence.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;
    @Autowired
    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Cliente guardaCliente(Cliente cliente) {
        return mapper.clienteEntityToClienteModel(
                repository.save(mapper.clienteModelToClienteEntity(cliente))
        );
    }

    public List<Cliente> obtenClientes(){
        return repository.findAll().stream().map(cliente -> mapper.clienteEntityToClienteModel(cliente)).collect(Collectors.toList());
    }

    public Optional<Cliente> obtenCliente(long idCliente) {
        return repository.findById(idCliente)
                .map(cliente -> Optional.of(mapper.clienteEntityToClienteModel(cliente)))
                .orElse(Optional.empty());
    }

    public void eliminaCliente(long idcliente){
        repository.deleteById(idcliente);
    }

    public Cliente actualizaCliente(Cliente cliente){
        return mapper.clienteEntityToClienteModel(
                repository.save(mapper.clienteModelToClienteEntity(cliente))
        );
    }

    public long cuenteClientes(){
        return repository.count();
    }
}
