package org.bedu.java.backend.proyecto.controllers.mappers;

import org.bedu.java.backend.proyecto.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.java.backend.proyecto.model.Visita visitaModel);

    org.bedu.java.backend.proyecto.model.Visita visitaEntityToVisitaModel(Visita visita);
}
