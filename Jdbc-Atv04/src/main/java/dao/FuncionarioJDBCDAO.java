package dao;

import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioJDBCDAO implements FuncionarioDAO {
    public FuncionarioJDBCDAO(){};
    @Override
    public void insert(Funcionario funcionario)throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String insert = "insert into funcionarios (cpf ,matricula, nome, email, telefone) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(insert);
        statement.setString(1, funcionario.getCpf());
        statement.setString(2, funcionario.getMatricula());
        statement.setString(3, funcionario.getNome());
        statement.setString(4, funcionario.getEmail());
        statement.setString(5, funcionario.getTelefone());

        statement.executeUpdate();
        con.close();

    }
    public void delete(int id)throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        String delete = "delete From funcionarios where id = ?";
        PreparedStatement pst = con.prepareStatement(delete);
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();

    }

    private Funcionario map(ResultSet resultSet) throws SQLException{
        Funcionario funcionario = new Funcionario();
        funcionario.setId(resultSet.getInt("id"));
        funcionario.setCpf(resultSet.getString("cpf"));
        funcionario.setMatricula(resultSet.getString("matricula"));
        funcionario.setNome(resultSet.getString("nome"));
        funcionario.setEmail(resultSet.getString("email"));
        funcionario.setTelefone(resultSet.getString("telefone"));

        return funcionario;
    }

    public List<Funcionario> find()throws SQLException{
        List<Funcionario> funcionarios = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        String select = "select * from funcionarios";
        PreparedStatement statement = con.prepareStatement(select);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Funcionario funcionario = map(resultSet);
            funcionarios.add(funcionario);
        }
        statement.close();

        return funcionarios;
    }
    public Funcionario find(int id)throws SQLException{
        Funcionario funcionario = new Funcionario();
        Connection con = ConnectionFactory.getConnection();
        String select = "select * from funcionarios where id = ?";
        PreparedStatement statement = con.prepareStatement(select);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            funcionario = map(resultSet);
        }
        statement.close();
        return funcionario;
    }
    public void update(Funcionario funcionario)throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        String update = "update funcionarios set cpf= ?, matricula= ?, nome=?, email=?, telefone=? where id =?";
        PreparedStatement statement = con.prepareStatement(update);
        statement.setString(1, funcionario.getCpf());
        statement.setString(2, funcionario.getMatricula());
        statement.setString(3, funcionario.getNome());
        statement.setString(4, funcionario.getEmail());
        statement.setString(5, funcionario.getTelefone());
        statement.setInt(6, funcionario.getId());
        statement.executeUpdate();

    }
}
