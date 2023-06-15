package com.proyecto.controllers.mappers;

import com.proyecto.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(com.proyecto.model.Venta ventaModel);

    com.proyecto.model.Venta ventaEntityToVentaModel(Venta venta);
}
