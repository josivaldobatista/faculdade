package com.faculdade.api.services;

import com.faculdade.api.domains.Curso;
import com.faculdade.api.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    public List<Curso> findAll() {
        return repo.findAll();
    }
}
