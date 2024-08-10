package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.entity.EnderecoFuncionario;
import com.roupas.lojaderoupas.service.EnderecoFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecofuncionario")
public class EnderecoFuncionarioController {

    @Autowired
    EnderecoFuncionarioService enderecoFuncionarioService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<EnderecoFuncionario> save(@RequestBody EnderecoFuncionario enderecoFuncionario) {
        try {
            var enderecoFuncionario1 = enderecoFuncionarioService.save(enderecoFuncionario);
            return new ResponseEntity<>(enderecoFuncionario1, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<EnderecoFuncionario> update(@RequestBody EnderecoFuncionario enderecoFuncionario) {
        try {
            var endereco = enderecoFuncionarioService.update(enderecoFuncionario);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EnderecoFuncionario> deleteById(@PathVariable Long id ) {
        try {
            enderecoFuncionarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<EnderecoFuncionario>> findAll() {
        try {
            var enderecoFuncionarios = enderecoFuncionarioService.findAll();
            return new ResponseEntity<>(enderecoFuncionarios, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Optional<EnderecoFuncionario>> findById(@PathVariable Long id) {
        try {
            var enderecoFuncionario = enderecoFuncionarioService.findById(id);
            return new ResponseEntity<>(enderecoFuncionario, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
