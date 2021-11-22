package com.example.atv_05.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.atv_05.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class FuncionarioJDBCDAO implements FuncionarioDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insert(Funcionario funcionario) throws SQLException {
        String insert_sql = "insert into funcionarios (cpf, nome, email, matricula, telefone) values (:cpf, :nome, :email ,:matricula, :telefone)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("cpf",  funcionario.getCpf())
                .addValue("nome",  funcionario.getNome())
                .addValue("email",  funcionario.getEmail())
                .addValue("telefone",  funcionario.getTelefone())
                .addValue("matricula",  funcionario.getMatricula());

        jdbcTemplate.update(insert_sql, params);
    }

    public void delete(int id) {
        String sql = "delete from funcionarios where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id",  id);
        jdbcTemplate.update(sql, params);
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

    @Override
    public List<Funcionario> find() throws SQLException {
        String sql = "select * from funcionarios";
        return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
    }

    @Override
    public Funcionario find(int id) throws SQLException {
        String sql = "select * from funcionarios where id = :id_";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id_", id);
        return jdbcTemplate.queryForObject(sql, namedParameters, (rs, rowNum) -> map(rs));
    }

    @Override
    public void update(Funcionario funcionario) throws SQLException {
        String update_sql = "update funcionarios set cpf = :cpf, nome = :nome, email = :email,telefone = :telefone, matricula = :matricula where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("cpf",  funcionario.getCpf())
                .addValue("nome",  funcionario.getNome())
                .addValue("email",  funcionario.getEmail())
                .addValue("telefone",  funcionario.getTelefone())
                .addValue("matricula",  funcionario.getMatricula());

            params.addValue("id", funcionario.getId());
            jdbcTemplate.update(update_sql, params);

    }
}


