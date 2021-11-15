package dao;

import model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public interface FuncionarioDAO {
    public void insert(Funcionario funcionario) throws SQLException;
    public void delete(int id)throws SQLException;
    public List<Funcionario> find()throws SQLException;
    public Funcionario find(int id)throws SQLException;
    public void update(Funcionario funcionario)throws SQLException;
}
