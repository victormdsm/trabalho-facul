package com.roupas.lojaderoupas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private String funcao;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoFuncionario endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Venda> vendas;
}
