package com.example.Atv_06.model;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@NamedQuery(name="Funcionario.getAllEmployees", query="SELECT f FROM Funcionario f")
@NamedQuery(name="Funcionario.deleteWithId", query="delete Funcionario as f where f.id like :id")
@NamedQuery(name="Funcionario.findById", query="select f from Funcionario as f where f.nome like :id")


@Entity
@Table(name = "Funcionarios")
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull @Getter @Setter private int id;
    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private String matricula;
    @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;
}
