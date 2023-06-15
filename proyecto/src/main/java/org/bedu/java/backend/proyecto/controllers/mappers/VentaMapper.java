package org.bedu.java.backend.proyecto.controllers.mappers;

import org.bedu.java.backend.proyecto.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.java.backend.proyecto.model.Venta ventaModel);

    org.bedu.java.backend.proyecto.model.Venta ventaEntityToVentaModel(Venta venta);
}
