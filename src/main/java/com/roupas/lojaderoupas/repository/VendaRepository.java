package com.roupas.lojaderoupas.repository;

import com.roupas.lojaderoupas.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByCliente_NomeContainingIgnoreCase(String nomeCliente);
    List<Venda> findByFuncionario_NomeContainingIgnoreCase(String nome);
    List<Venda> findTop10ByOrderByTotalDesc();
}
