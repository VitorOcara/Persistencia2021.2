package com.example.Atv_06.ui;

import com.example.Atv_06.dao.FuncionarioDao;
import com.example.Atv_06.dao.FuncionarioJPADAO;
import com.example.Atv_06.model.Funcionario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PrincipalJPA implements CommandLineRunner {
	FuncionarioDao funcionarioDAO = new FuncionarioJPADAO();

	public void insert(Funcionario funcionario){
		String cpf = JOptionPane.showInputDialog("CPF", funcionario.getCpf());
		String matricula = JOptionPane.showInputDialog("Matricula", funcionario.getMatricula());
		String nome = JOptionPane.showInputDialog("Nome", funcionario.getNome());
		String email = JOptionPane.showInputDialog("Email", funcionario.getEmail());
		String telefone = JOptionPane.showInputDialog("Telefone", funcionario.getTelefone());

		funcionario.setCpf(cpf);
		funcionario.setMatricula(matricula);
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setTelefone(telefone);
	}

	public static void main(String[] args) throws SQLException {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(PrincipalJPA.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		String menu = """
                Escolha uma opção:\s
                 1: Inserir Funcionário
                 2: Atualizar Funcionário
                 3: Listar Funcionários
                 4: Buscar Funcionário por Id
                 5: Deletar Funcionário
                 6: Sair\s""";
		char opcao = '0';
		while (opcao!='6'){
			Funcionario funcionario;
			opcao = JOptionPane.showInputDialog(menu).charAt(0);
			switch (opcao) {
				case '1' -> {
					funcionario = new Funcionario();
					insert(funcionario);
					funcionarioDAO.insert(funcionario);
				}
				case '2' -> {
					funcionario = new Funcionario();
					int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
					funcionario.setId(id);
					insert(funcionario);
					funcionarioDAO.update(funcionario);
				}
				case '3' -> {
					List<Funcionario> lis = funcionarioDAO.find();
					System.out.println(lis);
					listaFuncionarios(lis);

				}
				case '4' -> {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
					listaFuncionario(id);
				}
				case '5' -> {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
					funcionarioDAO.delete(id);
				}
			}
		}
	}

	private void listaFuncionarios(List<Funcionario> funcionarios) {
		List<String> dados = new ArrayList<>();
		for(Funcionario funcionario : funcionarios) {
			String data =
					"\nId: "+ funcionario.getId()+
							"\nNome: "+ funcionario.getNome()+
							"\nMatrícula: "+ funcionario.getMatricula()+
							"\nCpf: " + funcionario.getCpf()+
							"\nEmail: "+ funcionario.getEmail() +
							"\nTelefone: "+funcionario.getTelefone()+"\n";
			String separator ="====================";
			dados.add(data);
			dados.add(separator);
		}
		JOptionPane.showMessageDialog(null,dados);
	}

	private void listaFuncionario(int id) throws SQLException {
		Funcionario funcionario = funcionarioDAO.find(id);
		String data =
				"\nId: "+ funcionario.getId()+
						"\nNome: "+ funcionario.getNome()+
						"\nMatrícula: "+ funcionario.getMatricula()+
						"\nCpf: " + funcionario.getCpf()+
						"\nEmail: "+ funcionario.getEmail() +
						"\nTelefone: "+funcionario.getTelefone()+"\n";

		JOptionPane.showMessageDialog(null,data);
	}
}
