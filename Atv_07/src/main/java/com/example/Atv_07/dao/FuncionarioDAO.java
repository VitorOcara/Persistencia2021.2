package com.example.Atv_07.dao;

import java.util.List;

import com.example.Atv_07.entity.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer> {

    public Funcionario findFirstByCpf(String cpf);

    @Query("select f from Funcionario f where f.id = :id")
    public Funcionario findFistByid(int id);

    public List<Funcionario> findByNomeStartingWith(String str);


}
