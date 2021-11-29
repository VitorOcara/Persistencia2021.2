package com.example.atv_05.dao;

import com.example.atv_05.model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public interface FuncionarioDao {

    void insert(Funcionario funcionario) throws SQLException;
    void delete(int id)throws SQLException;
    List<Funcionario> find()throws SQLException;
    Funcionario find(int id)throws SQLException;
    void update(Funcionario funcionario)throws SQLException;
}
