package com.example.Trabalho02.entity;

import lombok.*;

import java.util.*;
import javax.persistence.*;
import java.sql.Date;



@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@NamedQuery(name = "alunoPorCpf", query = "select a from Aluno a where a.cpf = :cpf")
@NamedQuery(name = "alunoPorId", query = "select a from Aluno a where a.id = :id")
@NamedQuery(name = "alunoPorMatricula", query = "select a from Aluno a where a.matricula = :matricula")


public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @NonNull @Getter @Setter private String nome;
    @NonNull @Getter @Setter private String matricula;
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private Date datanascimento;

    @Transient
    @NonNull @Getter @Setter private String[] disciplinascursadas;

}