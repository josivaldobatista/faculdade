package com.faculdade.api.resources;

import java.util.List;

import com.faculdade.api.domains.Turma;
import com.faculdade.api.services.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
public class TurmaResource {
    
    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        List<Turma> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}