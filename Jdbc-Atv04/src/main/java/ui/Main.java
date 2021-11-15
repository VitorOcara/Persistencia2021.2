package ui;

import dao.FuncionarioDAO;
import dao.FuncionarioJDBCDAO;
import model.Funcionario;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void listaFuncionarios(List<Funcionario> funcionarios) {
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
    public static Funcionario returnFuncionario(int id) throws SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioJDBCDAO();
        return funcionarioDAO.find(id);
    }

    public static void listaFuncionario(int id) throws SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioJDBCDAO();
        Funcionario funcionario = funcionarioDAO.find(id);
        if(funcionario != null){
            String data =
                    "\nId: "+ funcionario.getId()+
                    "\nNome: "+ funcionario.getNome()+
                    "\nMatrícula: "+ funcionario.getMatricula()+
                    "\nCpf: " + funcionario.getCpf()+
                    "\nEmail: "+ funcionario.getEmail() +
                    "\nTelefone: "+funcionario.getTelefone()+"\n";
            JOptionPane.showMessageDialog(null,  data);

        }
    }

    public static void insert(Funcionario funcionario){
        String cpf = JOptionPane.showInputDialog("CPF", funcionario.getCpf());
        String matricula = JOptionPane.showInputDialog("Matricula", funcionario.getMatricula());
        String nome = JOptionPane.showInputDialog("Nome", funcionario.getNome());
        String email = JOptionPane.showInputDialog("Email", funcionario.getEmail());
        String telefone = JOptionPane.showInputDialog("Telefone", funcionario.getTelefone());

        if (cpf!=null)
            funcionario.setCpf(cpf);
        if (matricula!=null)
            funcionario.setMatricula(matricula);
        if (nome!=null)
            funcionario.setNome(nome);
        funcionario.setEmail(email);
        funcionario.setTelefone(telefone);
    }

    public static void main(String[] args) throws SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioJDBCDAO();
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
                case '3' -> listaFuncionarios(funcionarioDAO.find());
                case '4' -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    listaFuncionario(id);
                }
            }
        }
    }

}
