package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.*;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    @Autowired
    private VagaRepo vagaRepo;
    @Autowired
    private EmpresaRepo empresaRepo;
    @Autowired
    private AreaRepo areaRepo;

    @GetMapping
    public List<Vaga> listar() {
        return vagaRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscar(@PathVariable Long id) {
        return vagaRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Map<String, Object> body) {
        try {
            String titulo = (String) body.get("titulo");
            String descricao = (String) body.get("descricao");
            LocalDate publicacao = body.get("publicacao") == null 
                ? LocalDate.now() 
                : LocalDate.parse((String) body.get("publicacao"));
            boolean ativo = body.get("ativo") == null 
                ? true 
                : Boolean.parseBoolean(body.get("ativo").toString());
            Long empresaId = body.get("empresaId") == null 
                ? null 
                : Long.valueOf(body.get("empresaId").toString());
            Long areaId = body.get("areaId") == null 
                ? null 
                : Long.valueOf(body.get("areaId").toString());

            Empresa empresa = empresaId == null ? null : empresaRepo.findById(empresaId).orElse(null);
            Area area = areaId == null ? null : areaRepo.findById(areaId).orElse(null);

            Vaga vaga = new Vaga();
            vaga.setTitulo(titulo);
            vaga.setDescricao(descricao);
            vaga.setPublicacao(publicacao);
            vaga.setAtivo(ativo);
            vaga.setEmpresa(empresa);
            vaga.setArea(area);

            return ResponseEntity.ok(vagaRepo.save(vaga));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        return vagaRepo.findById(id).map(existing -> {
            if (body.containsKey("titulo")) {
                existing.setTitulo((String) body.get("titulo"));
            }
            if (body.containsKey("descricao")) {
                existing.setDescricao((String) body.get("descricao"));
            }
            if (body.containsKey("publicacao")) {
                existing.setPublicacao(LocalDate.parse((String) body.get("publicacao")));
            }
            if (body.containsKey("ativo")) {
                existing.setAtivo(Boolean.parseBoolean(body.get("ativo").toString()));
            }
            if (body.containsKey("empresaId")) {
                Long empresaId = Long.valueOf(body.get("empresaId").toString());
                existing.setEmpresa(empresaRepo.findById(empresaId).orElse(null));
            }
            if (body.containsKey("areaId")) {
                Long areaId = Long.valueOf(body.get("areaId").toString());
                existing.setArea(areaRepo.findById(areaId).orElse(null));
            }
            return ResponseEntity.ok(vagaRepo.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (vagaRepo.existsById(id)) {
            vagaRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}