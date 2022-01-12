package com.example.Trabalho02.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.Trabalho02.dao.AlunoDAO;

import com.example.Trabalho02.dao.DisciplinaDAO;
import com.example.Trabalho02.dao.RelacaoDAO;
import com.example.Trabalho02.entity.Aluno;
import com.example.Trabalho02.entity.Disciplina;
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
@EntityScan("com.example.Trabalho02.entity")
@EnableJpaRepositories("com.example.Trabalho02.dao")
public class CRUDAluno implements CommandLineRunner {
    @Autowired
    private AlunoDAO baseAlunos;

    @Autowired
    private RelacaoDAO relacaoDAO;

    @Autowired
    private DisciplinaDAO disciplinaDAO;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CRUDAluno.class);
        builder.headless(false).run(args);
    }


    public void obterAluno(Aluno cl) throws ParseException {
        String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
        String cpf = JOptionPane.showInputDialog("CPF", cl.getCpf());
        String email = JOptionPane.showInputDialog("email", cl.getEmail());
        String matricula = JOptionPane.showInputDialog("Matrícula", cl.getMatricula());
        String data = JOptionPane.showInputDialog("Digite a data de nascimento do aluno", cl.getDatanascimento());
        java.util.Date dd = new SimpleDateFormat("dd/MM/yyyy").parse(data);


        cl.setDatanascimento(alterDate(dd));
        cl.setMatricula(matricula);
        cl.setNome(nome);
        cl.setCpf(cpf);
        cl.setEmail(email);

    }

    public void buscarEnrrolado(List<Aluno> alunos){

        StringBuilder listagem = new StringBuilder();
        for(Aluno cl : alunos) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum aluno encontrado" : listagem);

    }

    public static void listaAlunos(List<Aluno> alunos) {
        StringBuilder listagem = new StringBuilder();
        for(Aluno cl : alunos) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum aluno encontrado" : listagem);
    }

    public static void listaCliente(Aluno cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum aluno encontrado" : cl);
    }

    public void relacionaAlunoComDisciplina(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser relacionado"));
        int id2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Disciplina a ser relacionada"));

        Aluno aluno = baseAlunos.findFistByid(id);
        Disciplina disciplina = disciplinaDAO.findFistByid(id2);
        if(aluno != null && disciplina!= null){
            Relacao relacao = new Relacao();
            relacao.setAluno(aluno);
            relacao.setDisciplina(disciplina);

            relacaoDAO.save(relacao);
        } else {
            JOptionPane.showMessageDialog(null, "Houve um Equivioco");
        }

    }

    public void findByCodigo(){
        String codigo = JOptionPane.showInputDialog("Codigo da Disciplina");

        Disciplina d = disciplinaDAO.findFistByCodigo(codigo);
        if(d!= null){

            List<Relacao> relacoes = relacaoDAO.findAll();
            List<Aluno> integrantes = new ArrayList<>();
            for (Relacao i: relacoes ){
                if(i.getDisciplina().getId() == d.getId()){
                    Aluno a = baseAlunos.findFistByid(i.getAluno().getId());
                    integrantes.add(a);
                }
            }
            listaAlunos(integrantes);
        }
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
                "7 - Exibir a partir de uma data de Nascimeto\n"+
                "8 - Exibir a partir de um nome\n" +
                "9 - Relacionar aluno com uma disciplina\n"+
                "0 - Exibir alunos relacionados a uma diciplina";


        char opcao;
        do {
            Aluno cl;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1' -> {     // Inserir
                    cl = new Aluno();
                    obterAluno(cl);
                    baseAlunos.save(cl);
                }
                case '2' -> {     // Atualizar por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser alterado"));
                    cl = baseAlunos.findFistByid(id);
                    obterAluno(cl);
                    baseAlunos.save(cl);
                }
                case '3' -> {     // Remover por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser alterado"));
                    cl = baseAlunos.findFistByid(id);
                    if (cl != null) {
                        baseAlunos.deleteById(cl.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o aluno não encontrado.");
                    }
                }
                case '4' -> {     // Exibir por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cl = baseAlunos.findById(id).orElse(null);
                    listaCliente(cl);
                }
                case '5' ->     // Exibir todos
                        listaAlunos(baseAlunos.findAll());
                case '6' -> {
                    String matricula = JOptionPane.showInputDialog("Digite a Matricula do aluno a ser buscada");
                    cl = baseAlunos.findFistByMatricula(matricula);
                    JOptionPane.showMessageDialog(null, "Nome: " + cl.getNome() +
                            "\nEmail :" + cl.getEmail());
                }
                case '7' -> {
                    String data = JOptionPane.showInputDialog("Digite a data de nascimento do aluno a ser buscada");
                    Date dd = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    listaAlunos(baseAlunos.findAlunosByDatanascimento(alterDate(dd)));
                }
                case '8' -> listaAlunos(baseAlunos.findByNomeStartingWith(JOptionPane.showInputDialog("Digito nome do aluno a ser buscado")));
                case '9' -> relacionaAlunoComDisciplina();
                case '0' -> findByCodigo();


            }

        } while(opcao != 'x');
    }
    public  java.sql.Date alterDate(java.util.Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(date);
        return java.sql.Date.valueOf(formattedDate);

    }
}
