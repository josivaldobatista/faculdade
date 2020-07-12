package com.faculdade.api.services;

import java.util.List;
import java.util.Optional;

import com.faculdade.api.domains.Turma;
import com.faculdade.api.repositories.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repo;

    public List<Turma> findAll() {
        return repo.findAll();
    }

    public Turma findById(Integer id) {
        Optional<Turma> obj = repo.findById(id);
        return obj.orElse(null);
    }

}