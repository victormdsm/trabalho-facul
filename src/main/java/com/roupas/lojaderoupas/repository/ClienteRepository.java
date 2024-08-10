package com.roupas.lojaderoupas.repository;

import com.roupas.lojaderoupas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
