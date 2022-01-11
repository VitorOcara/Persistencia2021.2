package com.example.Trabalho02.dao;

import com.example.Trabalho02.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina, Integer> {

    Disciplina findFistByid(int id);
}

