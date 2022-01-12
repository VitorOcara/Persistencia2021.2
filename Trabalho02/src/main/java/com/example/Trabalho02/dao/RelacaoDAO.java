package com.example.Trabalho02.dao;

import com.example.Trabalho02.entity.Relacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface RelacaoDAO extends JpaRepository<Relacao, Integer> {

}
