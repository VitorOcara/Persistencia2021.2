package com.example.Trabalho_02.dao;

import com.example.Trabalho_02.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

    public Aluno findFistAluno(String matricula);

    @Query(name = "alunoPorId")
    public Aluno buscaPorIdViaConsultaNomeada(int id);

    @Query("select a from Aluno a where a.nome like :nome%")
    public List<Aluno> buscaPorNomeIniciadoPor(String nome);
}
