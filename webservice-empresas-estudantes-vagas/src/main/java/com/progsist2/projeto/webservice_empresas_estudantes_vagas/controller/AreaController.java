package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Area;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.AreaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaRepo repo;

    @GetMapping
    public List<Area> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Area> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Area> criar(@RequestBody Area area) {
        return ResponseEntity.ok(repo.save(area));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> atualizar(@PathVariable Long id, @RequestBody Area dados) {
        return repo.findById(id).map(existing -> {
            existing.setNome(dados.getNome());
            return ResponseEntity.ok(repo.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @SuppressWarnings("null")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repo.existsById(id)) { repo.deleteById(id); return ResponseEntity.noContent().build(); }
        return ResponseEntity.notFound().build();
    }
}
