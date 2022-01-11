package com.example.Trabalho02.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "relacao")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Relacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @ManyToOne
    @Getter @Setter private Aluno aluno;

    @ManyToOne
    @Getter @Setter private Disciplina disciplina;

}
