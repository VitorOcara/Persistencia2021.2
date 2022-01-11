package com.example.Trabalho02.ui;


import com.example.Trabalho02.dao.RelacaoDAO;
import com.example.Trabalho02.entity.Aluno;
import com.example.Trabalho02.entity.Relacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.Trabalho02")
public class Main implements CommandLineRunner {

    @Autowired
    private RelacaoDAO relacaoDAO;



    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        builder.headless(false).run(args);
    }

    public void run(String[] args) {
        Aluno aluno = new Aluno();

        aluno.setId(3);
        Relacao relacao = new Relacao();
        relacao.setAluno(aluno);

        relacaoDAO.save(relacao);

    }
}
