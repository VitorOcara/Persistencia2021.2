package com.example.Trabalho_02.dao;

import com.example.Trabalho_02.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina, Integer> {
}
