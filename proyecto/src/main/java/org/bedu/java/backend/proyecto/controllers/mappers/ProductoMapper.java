package org.bedu.java.backend.proyecto.controllers.mappers;

import org.bedu.java.backend.proyecto.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.java.backend.proyecto.model.Producto productoModel);

    org.bedu.java.backend.proyecto.model.Producto productoEntityToProductoModel(Producto producto);
}
