package org.bedu.java.backend.proyecto.persistence;

import org.bedu.java.backend.proyecto.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
