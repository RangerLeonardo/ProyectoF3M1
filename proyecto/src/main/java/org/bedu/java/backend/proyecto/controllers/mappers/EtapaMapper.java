package org.bedu.java.backend.proyecto.controllers.mappers;

import org.bedu.java.backend.proyecto.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaModelToEtapaEntity(org.bedu.java.backend.proyecto.model.Etapa etapaModel);

    org.bedu.java.backend.proyecto.model.Etapa etapaEntityToEtapaModel(Etapa etapa);
}
