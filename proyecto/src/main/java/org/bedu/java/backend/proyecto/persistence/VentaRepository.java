package org.bedu.java.backend.proyecto.persistence;

import org.bedu.java.backend.proyecto.persistence.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
