package com.roupas.lojaderoupas.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos_funcionario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EnderecoFuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String numero;
    private String Bairro;
    private String cidade;

}
