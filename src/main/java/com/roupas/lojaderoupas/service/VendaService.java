package com.roupas.lojaderoupas.service;

import com.roupas.lojaderoupas.entity.Venda;
import com.roupas.lojaderoupas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda update(Venda venda) {
        if (vendaRepository.existsById(venda.getId())) {
            return vendaRepository.save(venda);
        } else {
            throw new RuntimeException("Venda não encontrada com ID: " + venda.getId());
        }
    }

    public void delete(Long id) {
        if (vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Venda não encontrada com ID: " + id);
        }
    }

    public Optional<Venda> findById(Long id) {
        return vendaRepository.findById(id);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public List<Venda> findByClienteNome(String nome) {
        return vendaRepository.findByCliente_NomeContainingIgnoreCase(nome);
    }

    public List<Venda> findByFuncionarioNome(String nome) {
        return vendaRepository.findByFuncionario_NomeContainingIgnoreCase(nome);
    }

    public List<Venda> findTop10Price() {
        return vendaRepository.findTop10ByOrderByTotalDesc();
    }
}
