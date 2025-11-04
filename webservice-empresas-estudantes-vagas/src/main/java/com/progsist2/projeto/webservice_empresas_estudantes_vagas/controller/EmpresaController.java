package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Empresa;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.EmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepo repo;

    @GetMapping
    public List<Empresa> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
        Empresa salvo = repo.save(empresa);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa dados) {
        return repo.findById(id).map(existing -> {
            existing.setNomeFantasia(dados.getNomeFantasia());
            existing.setCnpj(dados.getCnpj());
            existing.setEmailContato(dados.getEmailContato());
            existing.setEndereco(dados.getEndereco());
            existing.setDescricao(dados.getDescricao());
            return ResponseEntity.ok(repo.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repo.existsById(id)) { repo.deleteById(id); return ResponseEntity.noContent().build(); }
        return ResponseEntity.notFound().build();
    }
}
