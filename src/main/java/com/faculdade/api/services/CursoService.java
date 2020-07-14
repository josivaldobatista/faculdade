package com.faculdade.api.services;

import com.faculdade.api.domains.Curso;
import com.faculdade.api.dto.CursoDTO;
import com.faculdade.api.repositories.CursoRepository;
import com.faculdade.api.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    public List<Curso> findAll() {
        return repo.findAll();
    }

    public Curso findById(Integer id) {
        Optional<Curso> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Curso.class.getName()));
    }

    public Curso insert(Curso obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Curso fromDTO(CursoDTO objDto) {
        return new Curso(objDto.getId(), objDto.getNome(), objDto.getCargaHoraria(), objDto.getNotaMinima());
    }
}
