package com.faculdade.api.resources;

import com.faculdade.api.domains.Curso;
import com.faculdade.api.dto.CursoDTO;
import com.faculdade.api.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> listCurso = service.findAll();
        return ResponseEntity.ok().body(listCurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Curso obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CursoDTO objDto) {
        Curso obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
