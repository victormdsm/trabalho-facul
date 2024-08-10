package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.entity.Venda;
import com.roupas.lojaderoupas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        try {
            var venda1 = vendaService.save(venda);
            return new ResponseEntity<>(venda1, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<Venda> update(@RequestBody Venda venda) {
        try {
            var venda1 = vendaService.update(venda);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id ) {
        try {
            vendaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Venda>> findAll() {
        try {
            var vendas = vendaService.findAll();
            return new ResponseEntity<>(vendas, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Optional<Venda>> findById(@PathVariable Long id) {
        try {
            var venda = vendaService.findById(id);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
