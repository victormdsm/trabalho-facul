package com.roupas.lojaderoupas.service;

import com.roupas.lojaderoupas.entity.Produto;
import com.roupas.lojaderoupas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        if (produtoRepository.existsById(produto.getId())) {
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com ID: " + produto.getId());
        }
    }

    public void delete(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
