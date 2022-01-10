package com.example.Trabalho02.ui;

import java.util.List;

import javax.swing.JOptionPane;

import com.example.Trabalho02.dao.DisciplinaDAO;
import com.example.Trabalho02.entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.Trabalho02")
public class CrudDisciplina implements CommandLineRunner {
    @Autowired
    private DisciplinaDAO baseDisciplinas;

    public static void main(String[] args) {
        //SpringApplication.run(Principal.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CrudDisciplina.class);
        builder.headless(false).run(args);
    }

    public static void obterDisciplina(Disciplina dc) {
        String nome = JOptionPane.showInputDialog("Nome", dc.getNome());
        String codigo = JOptionPane.showInputDialog("Código", dc.getCodigo());

        dc.setNome(nome);
        dc.setCodigo(codigo);
    }

    public static void listaDisciplinas(List<Disciplina> disciplinas) {
        StringBuilder listagem = new StringBuilder();
        for(Disciplina cl : disciplinas) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhuma disciplina encontrado" : listagem);
    }


    @Override
    public void run(String... args) throws Exception {

        String menu = "Escolha uma opção:\n" +
                "1 - Inserir\n" +
                "2 - Atualizar por id\n" +
                "3 - Remover por id\n" +
                "4 - Exibir por id\n" +
                "5 - Exibir todos\n" +
                "9 - Sair";
        char opcao;
        do {
            Disciplina cl;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1':     // Inserir
                    cl = new Disciplina();
                    obterDisciplina(cl);
                    baseDisciplinas.save(cl);
                    break;
                case '2':     // Atualizar por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da Disciplina a ser alterada"));
                    cl = baseDisciplinas.findFistByid(id);
                    obterDisciplina(cl);
                    baseDisciplinas.save(cl);
                    break;
                case '3':     // Remover por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da Disciplina a ser alterada"));
                    cl = baseDisciplinas.findFistByid(id);
                    if (cl != null) {
                        baseDisciplinas.deleteById(cl.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois a Disciplina não foi encontrada.");
                    }
                    break;
                case '4':     // Exibir por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cl = baseDisciplinas.findFistByid(id);
                    if(cl!=null){
                        JOptionPane.showMessageDialog(null, cl);
                    }
                    break;
                case '5':     // Exibir todos
                    listaDisciplinas(baseDisciplinas.findAll());
                    break;
                case '9':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }

        } while(opcao != '9');
    }
}
