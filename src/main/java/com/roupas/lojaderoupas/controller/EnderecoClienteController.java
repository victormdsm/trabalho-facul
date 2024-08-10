package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.entity.EnderecoCliente;
import com.roupas.lojaderoupas.service.EnderecoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecocliente")
public class EnderecoClienteController {

    @Autowired
    EnderecoClienteService enderecoClienteService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<EnderecoCliente> save(@RequestBody EnderecoCliente endereco) {
        try {
            var enderecoCliente = enderecoClienteService.save(endereco);
            return new ResponseEntity<>(enderecoCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<EnderecoCliente> update(@RequestBody EnderecoCliente endereco) {
        try {
            var enderecoCliente = enderecoClienteService.update(endereco);
            return new ResponseEntity<>(enderecoCliente, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id ) {
        try {
            enderecoClienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<EnderecoCliente>> findAll() {
        try {
            var enderecoClientes = enderecoClienteService.findAll();
            return new ResponseEntity<>(enderecoClientes, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Optional<EnderecoCliente>> findById(@PathVariable Long id) {
        try {
            var enderecoCliente = enderecoClienteService.findById(id);
            return new ResponseEntity<>(enderecoCliente, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
