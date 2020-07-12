package com.faculdade.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.faculdade.api.domains.Turma;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TurmaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @Column(name = "numero_turma")
    private String numeroTurma;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;

    private Integer numeroVagas;

    public TurmaDTO() {
    }

    public TurmaDTO(Turma obj) {
        id = obj.getId();
        numeroTurma = obj.getNumeroTurma();
        dataInicio = obj.getDataInicio();
        numeroVagas = obj.getNumeroVagas();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroTurma() {
        return this.numeroTurma;
    }

    public void setNumeroTurma(String numeroTurma) {
        this.numeroTurma = numeroTurma;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getNumeroVagas() {
        return this.numeroVagas;
    }

    public void setNumeroVagas(Integer numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

}