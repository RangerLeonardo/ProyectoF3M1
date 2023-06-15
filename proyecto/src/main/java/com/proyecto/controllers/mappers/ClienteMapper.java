package com.proyecto.controllers.mappers;

import com.proyecto.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(com.proyecto.model.Cliente clienteModel);

    com.proyecto.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}
