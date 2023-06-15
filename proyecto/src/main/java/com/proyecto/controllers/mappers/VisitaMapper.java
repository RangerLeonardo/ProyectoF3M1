package com.proyecto.controllers.mappers;

import com.proyecto.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(com.proyecto.model.Visita visitaModel);

    com.proyecto.model.Visita visitaEntityToVisitaModel(Visita visita);
}
