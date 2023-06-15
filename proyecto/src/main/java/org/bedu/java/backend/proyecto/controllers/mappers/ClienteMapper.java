package org.bedu.java.backend.proyecto.controllers.mappers;

import org.bedu.java.backend.proyecto.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(org.bedu.java.backend.proyecto.model.Cliente clienteModel);

    org.bedu.java.backend.proyecto.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}
