package com.proyecto.controllers.mappers;

import com.proyecto.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaModelToEtapaEntity(com.proyecto.model.Etapa etapaModel);

    com.proyecto.model.Etapa etapaEntityToEtapaModel(Etapa etapa);
}
