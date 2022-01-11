package com.example.Trabalho02.entity;

import lombok.*;


import javax.persistence.*;
import java.sql.Date;
import java.util.*;



@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "associacoes")

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

    @OneToMany(mappedBy = "aluno")
    @Getter @Setter private List<Disciplina> associacoes;

}