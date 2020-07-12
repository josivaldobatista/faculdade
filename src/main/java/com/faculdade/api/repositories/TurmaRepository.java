package com.faculdade.api.repositories;

import com.faculdade.api.domains.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository  extends JpaRepository<Turma, Integer> {
}