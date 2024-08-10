package com.roupas.lojaderoupas.service;

import com.roupas.lojaderoupas.entity.EnderecoFuncionario;
import com.roupas.lojaderoupas.repository.EnderecoFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoFuncionarioService {

    @Autowired
    private EnderecoFuncionarioRepository enderecoFuncionarioRepository;

    public EnderecoFuncionario save(EnderecoFuncionario enderecoFuncionario) {
        return enderecoFuncionarioRepository.save(enderecoFuncionario);
    }

    public EnderecoFuncionario update(EnderecoFuncionario enderecoFuncionario) {
        if (enderecoFuncionarioRepository.existsById(enderecoFuncionario.getId())) {
            return enderecoFuncionarioRepository.save(enderecoFuncionario);
        } else {
            throw new RuntimeException("EnderecoFuncionario não encontrado com ID: " + enderecoFuncionario.getId());
        }
    }

    public void delete(Long id) {
        if (enderecoFuncionarioRepository.existsById(id)) {
            enderecoFuncionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("EnderecoFuncionario não encontrado com ID: " + id);
        }
    }

    public Optional<EnderecoFuncionario> findById(Long id) {
        return enderecoFuncionarioRepository.findById(id);
    }

    public List<EnderecoFuncionario> findAll() {
        return enderecoFuncionarioRepository.findAll();
    }

}
