package com.proyecto.services;



import com.proyecto.controllers.mappers.VisitaMapper;
import com.proyecto.model.Visita;
import com.proyecto.persistence.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitaService {
    private final VisitaRepository repository;
    private final VisitaMapper mapper;
    @Autowired
    public VisitaService(VisitaRepository repository, VisitaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public Visita guardaVisita(Visita visita) {
        return mapper.visitaEntityToVisitaModel(
                repository.save(mapper.visitaModelToVisitaEntity(visita))
        );
    }

    public List<Visita> obtenVisitas(){
        return repository.findAll().stream().map(visita -> mapper.visitaEntityToVisitaModel(visita)).collect(Collectors.toList());
    }

    public Optional<Visita> obtenVisita(long idVisita) {
        return repository.findById(idVisita)
                .map(Visita -> Optional.of(mapper.visitaEntityToVisitaModel(Visita)))
                .orElse(Optional.empty());
    }

    public void eliminaVisita(long idVisita){
        repository.deleteById(idVisita);
    }

    public Visita actualizaVisita(Visita visita){
        return mapper.visitaEntityToVisitaModel(
                repository.save(mapper.visitaModelToVisitaEntity(visita))
        );
    }

    public long cuenteVisitas(){
        return repository.count();
    }
}
