package com.faculdade.api.services;

import java.util.List;
import java.util.Optional;

import com.faculdade.api.domains.Curso;
import com.faculdade.api.dto.CursoDTO;
import com.faculdade.api.repositories.CursoRepository;
import com.faculdade.api.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Curso insert(Curso obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public Curso update(Curso obj) {
        Curso newObj = findById(obj.getId()); // Verificando se o objeto existe.
        BeanUtils.copyProperties(obj, newObj, "id");
        return repo.save(newObj);
    }

    public void updateNome(Integer id, String nome) {
        Curso obj = findById(id);
        obj.setNome(nome);
        repo.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repo.deleteById(id);
    }

    public Curso fromDTO(CursoDTO objDto) {
        return new Curso(objDto.getId(), objDto.getNome(), objDto.getCargaHoraria(), objDto.getNotaMinima());
    }

    public Page<Curso> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    /*
     * public void updateData(Curso newObj, Curso obj) {
     * newObj.setNome(obj.getNome()); newObj.setCargaHoraria(obj.getCargaHoraria());
     * newObj.setNotaMinima(obj.getNotaMinima()); }
     */

}
