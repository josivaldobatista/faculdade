package com.faculdade.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.faculdade.api.domains.Curso;

import org.hibernate.validator.constraints.Length;

public class CursoDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres!")
    private String nome;

    @NotNull(message = "Preenchimento obrigatório!")
    private Integer cargaHoraria;

    @NotNull(message = "Preenchimento obrigatório!")
    private Double notaMinima;

    public CursoDTO() {
    }

    public CursoDTO(Curso obj) {
        id = obj.getId();
        nome = obj.getNome();
        cargaHoraria = obj.getCargaHoraria();
        notaMinima = obj.getNotaMinima();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Double getNotaMinima() {
        return this.notaMinima;
    }

    public void setNotaMinima(Double notaMinima) {
        this.notaMinima = notaMinima;
    }

}