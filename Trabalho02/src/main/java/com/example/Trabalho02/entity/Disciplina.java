package com.example.Trabalho02.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "disciplinas")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @NonNull @Getter @Setter private String nome;
    @NonNull @Getter @Setter private String codigo;


    @ToString.Exclude
    @OneToMany(mappedBy = "disciplina")
    @Getter @Setter private List<Relacao> relacaos;
}
