package com.faculdade.api.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Turma implements Serializable {
    private static final long serialVersionUID = -6583436761583421456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_turma")
    private String numeroTurma;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "numero_vagas")
    private Integer numeroVagas;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Turma() {
    }

    public Turma(Integer id, String numeroTurma, Date dataInicio, Integer numeroVagas, Curso curso) {
        this.id = id;
        this.numeroTurma = numeroTurma;
        this.dataInicio = dataInicio;
        this.numeroVagas = numeroVagas;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroTurma() {
        return numeroTurma;
    }

    public void setNumeroTurma(String numeroTurma) {
        this.numeroTurma = numeroTurma;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(Integer numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Turma turma = (Turma) o;
        return id.equals(turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
