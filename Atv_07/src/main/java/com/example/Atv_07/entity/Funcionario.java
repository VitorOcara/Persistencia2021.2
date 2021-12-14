package com.example.Atv_07.entity;

import lombok.*;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "funcionarioPorCpf", query = "select f from Funcionario f where f.cpf = :cpf")
})

@Entity
@Table(name = "funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull @Getter @Setter private int id;
    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private String matricula;
    @Getter @Setter private String nome;
    @Getter @Setter private String telefone;
    @Getter @Setter private String email;
}
