package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Funcionario;
import com.roupas.lojaderoupas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService FuncionarioService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        try {
            var func = FuncionarioService.save(funcionario);
            return new ResponseEntity<>(func, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario) {
        try {
            var func = FuncionarioService.update(funcionario);
            return new ResponseEntity<>(func, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id ) {
        try {
            FuncionarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Funcionario>> findAll() {
        try {
            var funcionarios = FuncionarioService.findAll();
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Optional<Funcionario>> findById(@PathVariable Long id) {
        try {
            var funcionario = FuncionarioService.findById(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
