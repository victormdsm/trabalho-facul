package com.roupas.lojaderoupas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoCliente endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Venda> compras;

}
