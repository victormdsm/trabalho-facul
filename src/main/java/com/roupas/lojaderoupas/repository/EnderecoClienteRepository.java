package com.roupas.lojaderoupas.repository;

import com.roupas.lojaderoupas.LojaderoupasApplication;
import com.roupas.lojaderoupas.entity.EnderecoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
}
