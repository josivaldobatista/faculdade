package com.faculdade.api.services;

import java.util.List;
import java.util.Optional;

import com.faculdade.api.domains.Turma;
import com.faculdade.api.dto.TurmaDTO;
import com.faculdade.api.repositories.CursoRepository;
import com.faculdade.api.repositories.TurmaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repo;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Turma> findAll() {
        return repo.findAll();
    }

    public Turma findById(Integer id) {
        Optional<Turma> obj = repo.findById(id);
        return obj.orElse(null);
    }

    @Transactional
    public Turma insert(Turma obj) {
        obj.setId(null);
        obj = repo.save(obj);
        cursoRepository.save(obj.getCurso());
        return obj;
    }

    public Turma update(Turma obj) {
        Turma newObj = findById(obj.getId()); // Verificando se o objeto existe.
        BeanUtils.copyProperties(obj, newObj, "id");
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        repo.deleteById(id);
    }

    public Turma fromDTO(TurmaDTO objDto) {
        return new Turma(objDto.getId(), objDto.getNumeroTurma(), objDto.getDataInicio(),
            objDto.getNumeroVagas(), null);
    }

    public Page<Turma> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

}