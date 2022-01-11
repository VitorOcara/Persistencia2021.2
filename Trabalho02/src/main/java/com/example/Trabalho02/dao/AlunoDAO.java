package com.example.Trabalho02.dao;

import java.sql.Date;
import java.util.List;

import com.example.Trabalho02.entity.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

    public Aluno findFirstByCpf(String cpf);

    @Query("select a from Aluno a where a.id = :id")
    public Aluno findFistByid(int id);

    public List<Aluno> findByNomeStartingWith(String str);

    @Query(name ="alunoPormatricula")
    public Aluno findFistByMatricula(String str);

    @Query ("select a from Aluno a where a.datanascimento >= :data Order By datanascimento")
    public List<Aluno> findAlunosByDatanascimento(Date data);
}
