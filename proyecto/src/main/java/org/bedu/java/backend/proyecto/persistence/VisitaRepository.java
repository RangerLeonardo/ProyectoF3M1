package org.bedu.java.backend.proyecto.persistence;

import org.bedu.java.backend.proyecto.persistence.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
}
