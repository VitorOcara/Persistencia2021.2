package com.example.Trabalho_02.ui;

import com.example.Trabalho_02.tests.Teste;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		Teste teste = new Teste();
		teste.cadastrarAlunos();

	}

}
