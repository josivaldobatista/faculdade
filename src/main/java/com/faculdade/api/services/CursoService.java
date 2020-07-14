package com.faculdade.api.services;

import java.util.List;
import java.util.Optional;

import com.faculdade.api.domains.Curso;
import com.faculdade.api.dto.CursoDTO;
import com.faculdade.api.repositories.CursoRepository;
import com.faculdade.api.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Curso update(Curso obj) {
        Curso newObj = findById(obj.getId());
        BeanUtils.copyProperties(obj, newObj, "id");
        return repo.save(newObj);
    }

    public Curso fromDTO(CursoDTO objDto) {
        return new Curso(objDto.getId(), objDto.getNome(), objDto.getCargaHoraria(), 
            objDto.getNotaMinima());
    }

	public void updateNome(Integer id, String nome) {
        Curso obj = findById(id);
        obj.setNome(nome);
        repo.save(obj);
	}

    /* public void updateData(Curso newObj, Curso obj) {
        newObj.setNome(obj.getNome());
        newObj.setCargaHoraria(obj.getCargaHoraria());
        newObj.setNotaMinima(obj.getNotaMinima());
    } */

}
