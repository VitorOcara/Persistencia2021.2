package com.example.Trabalho02.ui;

import java.util.List;

import javax.swing.JOptionPane;

import com.example.Trabalho02.dao.AlunoDAO;
import com.example.Trabalho02.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.Trabalho02")
@EntityScan("com.example.Trabalho02.entity")
@EnableJpaRepositories("com.example.Trabalho02.dao")
public class CRUDAluno implements CommandLineRunner {
    @Autowired
    private AlunoDAO baseAlunos;

    public static void main(String[] args) {
        //SpringApplication.run(Principal.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CRUDAluno.class);
        builder.headless(false).run(args);
    }

    public static void obterCliente(Aluno cl) {
        String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
        String cpf = JOptionPane.showInputDialog("CPF", cl.getCpf());
        String email = JOptionPane.showInputDialog("email", cl.getEmail());
        String matricula = JOptionPane.showInputDialog("Matrícula", cl.getMatricula());

        cl.setMatricula(matricula);
        cl.setNome(nome);
        cl.setCpf(cpf);
        cl.setEmail(email);
    }

    public static void listaClientes(List<Aluno> alunos) {
        StringBuilder listagem = new StringBuilder();
        for(Aluno cl : alunos) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum aluno encontrado" : listagem);
    }

    public static void listaCliente(Aluno cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum aluno encontrado" : cl);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(baseAlunos.findByNomeStartingWith("773362552"));

        String menu = "Escolha uma opção:\n" +
                "1 - Inserir\n" +
                "2 - Atualizar por id\n" +
                "3 - Remover por id\n" +
                "4 - Exibir por id\n" +
                "5 - Exibir todos\n" +
                "6 - Exibir email e Nome por Matricula\n"+
                "9 - Sair";
        char opcao;
        do {
            Aluno cl;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1':     // Inserir
                    cl = new Aluno();
                    obterCliente(cl);
                    baseAlunos.save(cl);
                    break;
                case '2':     // Atualizar por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser alterado"));
                    cl = baseAlunos.findFistByid(id);
                    obterCliente(cl);
                    baseAlunos.save(cl);
                    break;
                case '3':     // Remover por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser alterado"));
                    cl = baseAlunos.findFistByid(id);
                    if (cl != null) {
                        baseAlunos.deleteById(cl.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o aluno não encontrado.");
                    }
                    break;
                case '4':     // Exibir por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cl = baseAlunos.findById(id).orElse(null);
                    listaCliente(cl);
                    break;
                case '5':     // Exibir todos
                    listaClientes(baseAlunos.findAll());
                    break;
                case '6':
                   String matricula = JOptionPane.showInputDialog("Digite a Matricula do aluno a ser buscada");
                    cl = baseAlunos.findFistByMatricula(matricula);
                    JOptionPane.showMessageDialog(null,"Nome: "+ cl.getNome()+
                            "\nEmail :" + cl.getEmail());

                case '9':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }

        } while(opcao != '9');
    }
}
