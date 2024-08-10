package com.roupas.lojaderoupas.service;

import com.roupas.lojaderoupas.entity.Funcionario;
import com.roupas.lojaderoupas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository FuncionarioRepository;

    public Funcionario save(Funcionario funcionario) {
        return FuncionarioRepository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario) {
        Optional<Funcionario> FuncionarioOptional = FuncionarioRepository.findById(funcionario.getId());
        if(FuncionarioOptional.isPresent()) {
            return FuncionarioRepository.save(funcionario);
        }else {
            throw new RuntimeException("Funcionario não encontrado com id: " + funcionario.getId());
        }
    }

    public Optional<Funcionario> findById(Long id) {
        return FuncionarioRepository.findById(id);
    }

    public List<Funcionario> findAll() {
        return FuncionarioRepository.findAll();
    }

    public void delete(Long id) {
        FuncionarioRepository.deleteById(id);
    }
}
