package com.roupas.lojaderoupas.service;

import com.roupas.lojaderoupas.entity.EnderecoCliente;
import com.roupas.lojaderoupas.repository.EnderecoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoClienteService {

    @Autowired
    private EnderecoClienteRepository enderecoClienteRepository;

    public EnderecoCliente save(EnderecoCliente enderecoCliente) {
        return enderecoClienteRepository.save(enderecoCliente);
    }

    public EnderecoCliente update(EnderecoCliente enderecoCliente) {
        if (enderecoClienteRepository.existsById(enderecoCliente.getId())) {
            return enderecoClienteRepository.save(enderecoCliente);
        } else {
            throw new RuntimeException("EnderecoCliente não encontrado com ID: " + enderecoCliente.getId());
        }
    }

    public void delete(Long id) {
        if (enderecoClienteRepository.existsById(id)) {
            enderecoClienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("EnderecoCliente não encontrado com ID: " + id);
        }
    }

    public Optional<EnderecoCliente> findById(Long id) {
        return enderecoClienteRepository.findById(id);
    }

    public List<EnderecoCliente> findAll() {
        return enderecoClienteRepository.findAll();
    }
}
