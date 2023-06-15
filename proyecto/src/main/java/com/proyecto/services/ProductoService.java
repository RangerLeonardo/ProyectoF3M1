package com.proyecto.services;


import com.proyecto.controllers.mappers.ProductoMapper;
import com.proyecto.model.Producto;
import com.proyecto.persistence.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    private final ProductoRepository repository;
    private final ProductoMapper mapper;
    @Autowired
    public ProductoService(ProductoRepository repository, ProductoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public Producto guardaProducto(Producto producto) {
        return mapper.productoEntityToProductoModel(
                repository.save(mapper.productoModelToProductoEntity(producto))
        );
    }

    public List<Producto> obtenProductos(){
        return repository.findAll().stream().map(Producto -> mapper.productoEntityToProductoModel(Producto)).collect(Collectors.toList());
    }

    public Optional<Producto> obtenProducto(long idProducto) {
        return repository.findById(idProducto)
                .map(producto -> Optional.of(mapper.productoEntityToProductoModel(producto)))
                .orElse(Optional.empty());
    }

    public void eliminaProducto(long idProducto){
        repository.deleteById(idProducto);
    }

    public Producto actualizaProducto(Producto producto){
        return mapper.productoEntityToProductoModel(
                repository.save(mapper.productoModelToProductoEntity(producto))
        );
    }

    public long cuenteProductos(){
        return repository.count();
    }
}
