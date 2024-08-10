package com.roupas.lojaderoupas.repository;

import com.roupas.lojaderoupas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findTop10ByOrderByPrecoDesc();
}
