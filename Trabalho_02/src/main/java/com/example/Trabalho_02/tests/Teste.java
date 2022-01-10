package com.example.Trabalho_02.tests;

import com.example.Trabalho_02.entity.Aluno;



public class Teste {

    public void resetDataBase(){

    }

    public void cadastrarAlunos() {
        Aluno a = new Aluno();
        a.setNome("Caio");
        a.setEmail("MasLevanto@email.com");
        a.setMatricula("33221040");
        a.setDisciplinas(new String[]{"222", "2222"});
        a.setDataNascimento("04-02-2001");
        System.out.println(a);
    }
}
