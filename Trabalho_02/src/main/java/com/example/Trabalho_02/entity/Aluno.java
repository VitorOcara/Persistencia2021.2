package com.example.Trabalho_02.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "alunoPorId", query = "select a from Aluno a where a.id = :id")
})
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @NonNull @Getter @Setter private String nome;
    @NonNull @Getter @Setter private String matricula;
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String dataNascimento;
    @NonNull @Getter @Setter private String[] disciplinas;

}
