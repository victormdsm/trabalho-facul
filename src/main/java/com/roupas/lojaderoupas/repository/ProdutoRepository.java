package com.roupas.lojaderoupas.repository;

import com.roupas.lojaderoupas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
