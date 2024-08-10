package com.roupas.lojaderoupas.repository;

import com.roupas.lojaderoupas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByIdadeBetween(int minIdade, int maxIdade);
}
