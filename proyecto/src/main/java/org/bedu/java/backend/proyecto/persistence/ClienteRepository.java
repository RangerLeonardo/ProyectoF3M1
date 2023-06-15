package org.bedu.java.backend.proyecto.persistence;

import org.bedu.java.backend.proyecto.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
