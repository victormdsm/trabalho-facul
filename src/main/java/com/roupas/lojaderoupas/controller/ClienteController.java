package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        try {
            var client = clienteService.save(cliente);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        try {
            var client = clienteService.update(cliente);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id ) {
        try {
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            var clientes = clienteService.findAll();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        try {
            var cliente = clienteService.findById(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
