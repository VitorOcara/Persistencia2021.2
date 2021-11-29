package com.example.Atv_06.dao;

import com.example.Atv_06.Utils.JPAUtil;
import com.example.Atv_06.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FuncionarioJPADAO implements FuncionarioDao {
    @Autowired
    EntityManager em;

    @Override
    public void insert(Funcionario funcionario) throws SQLException {
        em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            em.persist(funcionario);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        em = JPAUtil.getEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.getTransaction().begin();
        em.remove(funcionario);
        em.getTransaction().commit();
    }

    @Override
    public List<Funcionario> find() throws SQLException {
        em = JPAUtil.getEntityManager();
        List<Funcionario> l = em.createQuery("select f from Funcionario as f", Funcionario.class).getResultList();
        return l;
    }

    @Override
    public Funcionario find(int id) throws SQLException {
        em = JPAUtil.getEntityManager();
        return em.find(Funcionario.class, id);
    }

    @Override
    public void update(Funcionario funcionario) throws SQLException {
        em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }
}
