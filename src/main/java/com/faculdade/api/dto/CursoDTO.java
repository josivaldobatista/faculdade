package com.faculdade.api.dto;

import java.io.Serializable;

public class CursoDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Integer cargaHoraria;
    private Double notaMinima;

    public CursoDTO() {
    }

    public CursoDTO(Integer id, String nome, Integer cargaHoraria, Double notaMinima) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.notaMinima = notaMinima;
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