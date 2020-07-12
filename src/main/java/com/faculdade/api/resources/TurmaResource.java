package com.faculdade.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.faculdade.api.domains.Turma;
import com.faculdade.api.dto.TurmaDTO;
import com.faculdade.api.services.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
public class TurmaResource {
    
    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> findAll() {
        List<Turma> list = service.findAll();
        List<TurmaDTO> listDto = list.stream().map(obj -> new TurmaDTO(obj))
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        Turma obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}