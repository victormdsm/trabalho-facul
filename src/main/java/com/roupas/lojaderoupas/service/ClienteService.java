package com.roupas.lojaderoupas.service;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.repository.ClienteRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());
        if(clienteOptional.isPresent()) {
           return clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("Cliente não encontrado com id: " + cliente.getId());
        }
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findByIdadeBetween(Integer minIdade, Integer maxIdade){
        return clienteRepository.findByIdadeBetween(minIdade, maxIdade);
    }

}
