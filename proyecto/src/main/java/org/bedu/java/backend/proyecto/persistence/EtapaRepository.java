package org.bedu.java.backend.proyecto.persistence;

import org.bedu.java.backend.proyecto.persistence.entities.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapaRepository extends JpaRepository<Etapa, Long> {
}
