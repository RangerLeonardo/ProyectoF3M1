package com.proyecto.controllers.mappers;

import com.proyecto.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(com.proyecto.model.Producto productoModel);

    com.proyecto.model.Producto productoEntityToProductoModel(Producto producto);
}
