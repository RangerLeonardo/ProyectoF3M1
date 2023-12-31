package com.proyecto.model;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Cliente {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private long id;

    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre del cliente debe tener al menos 5 letras y ser menor a 30")
    private String nombre;

    @Email
    private String correoContacto;

    @Min(value = 10, message = "Los clientes con menos de 10 empleados no son válidos")
    @Max(value = 10000, message = "Los clientes con más de 10000 empleados no son válidos")
    private int numeroEmpleados;

    @NotBlank(message = "Se debe proporcionar una dirección")
    private String direccion;

    public long getId() {
        return id;
    }
}
