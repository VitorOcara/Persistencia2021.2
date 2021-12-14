package com.example.Atv_07.ui;

import java.util.List;

import javax.swing.JOptionPane;

import com.example.Atv_07.dao.FuncionarioDAO;
import com.example.Atv_07.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.Atv_07")
@EntityScan("com.example.Atv_07.entity")
@EnableJpaRepositories("com.example.Atv_07.dao")
public class Principal implements CommandLineRunner {
    @Autowired
    private FuncionarioDAO baseFuncionarios;

    public static void main(String[] args) {
        //SpringApplication.run(Principal.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Principal.class);
        builder.headless(false).run(args);
    }

    public static void obterCliente(Funcionario cl) {
        String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
        String cpf = JOptionPane.showInputDialog("CPF", cl.getCpf());
        String telefone = JOptionPane.showInputDialog("telefone", cl.getTelefone());
        String email = JOptionPane.showInputDialog("email", cl.getEmail());
        String matricula = JOptionPane.showInputDialog("Matrícula", cl.getMatricula());

        cl.setMatricula(matricula);
        cl.setNome(nome);
        cl.setCpf(cpf);
        cl.setEmail(email);
        cl.setTelefone(telefone);
    }

    public static void listaClientes(List<Funcionario> funcionarios) {
        StringBuilder listagem = new StringBuilder();
        for(Funcionario cl : funcionarios) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum cliente encontrado" : listagem);
    }

    public static void listaCliente(Funcionario cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum cliente encontrado" : cl);
    }

    @Override
    public void run(String... args) throws Exception {
        String menu = "Escolha uma opção:\n" +
                "1 - Inserir\n" +
                "2 - Atualizar por id\n" +
                "3 - Remover por id\n" +
                "4 - Exibir por id\n" +
                "5 - Exibir todos\n" +
                "6 - Sair";
        char opcao;
        do {
            Funcionario cl;
            String cpf;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1':     // Inserir
                    cl = new Funcionario();
                    obterCliente(cl);
                    baseFuncionarios.save(cl);
                    break;
                case '2':     // Atualizar por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente a ser alterado"));
                    cl = baseFuncionarios.findFistByid(id);
                    obterCliente(cl);
                    baseFuncionarios.save(cl);
                    break;
                case '3':     // Remover por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente a ser alterado"));
                    cl = baseFuncionarios.findFistByid(id);
                    if (cl != null) {
                        baseFuncionarios.deleteById(cl.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o cliente não encontrado.");
                    }
                    break;
                case '4':     // Exibir por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cl = baseFuncionarios.findById(id).orElse(null);
                    listaCliente(cl);
                    break;
                case '5':     // Exibir todos
                    listaClientes(baseFuncionarios.findAll());
                    break;
                case '6':     // Sair
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }

        } while(opcao != '6');
    }
}
