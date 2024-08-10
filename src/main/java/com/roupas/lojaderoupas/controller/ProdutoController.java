package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.entity.Produto;
import com.roupas.lojaderoupas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        try {
            var produto1 = produtoService.save(produto);
            return new ResponseEntity<>(produto1, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        try {
            var produto1 = produtoService.update(produto);
            return new ResponseEntity<>(produto1, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id ) {
        try {
            produtoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Produto>> findAll() {
        try {
            var produto = produtoService.findAll();
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) {
        try {
            var produto = produtoService.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
