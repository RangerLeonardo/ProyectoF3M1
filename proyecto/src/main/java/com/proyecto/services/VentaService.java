package com.proyecto.services;
import com.proyecto.controllers.mappers.VentaMapper;
import com.proyecto.model.Venta;
import com.proyecto.persistence.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaService {
    private final VentaRepository repository;
    private final VentaMapper mapper;
    @Autowired
    public VentaService(VentaRepository repository, VentaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Venta guardaVenta(Venta Venta) {
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(Venta))
        );
    }

    public List<Venta> obtenVentas(){
        return repository.findAll().stream().map(venta -> mapper.ventaEntityToVentaModel(venta)).collect(Collectors.toList());
    }

    public Optional<Venta> obtenVenta(long idVenta) {
        return repository.findById(idVenta)
                .map(venta -> Optional.of(mapper.ventaEntityToVentaModel(venta)))
                .orElse(Optional.empty());
    }

    public void eliminaVenta(long idVenta){
        repository.deleteById(idVenta);
    }

    public Venta actualizaVenta(Venta venta){
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(venta))
        );
    }

    public long cuenteVentas(){
        return repository.count();
    }
}
