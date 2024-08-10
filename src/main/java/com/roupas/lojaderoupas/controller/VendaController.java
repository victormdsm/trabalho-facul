package com.roupas.lojaderoupas.controller;

import com.roupas.lojaderoupas.entity.Cliente;
import com.roupas.lojaderoupas.entity.Funcionario;
import com.roupas.lojaderoupas.entity.Produto;
import com.roupas.lojaderoupas.entity.Venda;
import com.roupas.lojaderoupas.service.ClienteService;
import com.roupas.lojaderoupas.service.FuncionarioService;
import com.roupas.lojaderoupas.service.ProdutoService;
import com.roupas.lojaderoupas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        try {
            BigDecimal total = BigDecimal.ZERO;
            Optional<Cliente> clienteOpt = clienteService.findById(venda.getCliente().getId());
            if (clienteOpt.isPresent()) {
                venda.setCliente(clienteOpt.get());
            }
            Optional<Funcionario> funcionarioOpt = funcionarioService.findById(venda.getFuncionario().getId());
            if (funcionarioOpt.isPresent()) {
                venda.setFuncionario(funcionarioOpt.get());
            }
            List<Produto> produtosValidos = new ArrayList<>();
            for (Produto produto : venda.getProdutos()) {
                Optional<Produto> produtoOpt = produtoService.findById(produto.getId());
                if (produtoOpt.isPresent()) {
                    total.add(produto.getPreco());
                    produtosValidos.add(produtoOpt.get());
                }
            }
            venda.setTotal(total);
            venda.setProdutos(produtosValidos);
            Venda savedVenda = vendaService.save(venda);
            return new ResponseEntity<>(savedVenda, HttpStatus.CREATED);
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

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<List<Venda>> findByClienteName(@PathVariable String nome) {
        try {
            var venda = vendaService.findByClienteNome(nome);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/funcionario/{nome}")
    public ResponseEntity<List<Venda>> findByFuncionarioName(@PathVariable String nome) {
        try {
            var venda = vendaService.findByFuncionarioNome(nome);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findtop10")
    public ResponseEntity<List<Venda>> findTop10() {
        try {
            var venda = vendaService.findTop10Price();
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
