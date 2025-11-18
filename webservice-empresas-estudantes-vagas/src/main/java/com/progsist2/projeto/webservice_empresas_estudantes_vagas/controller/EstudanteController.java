package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.*;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteRepo estudanteRepo;
    @Autowired
    private AreaRepo areaRepo;

    @GetMapping
    public List<Estudante> listar() {
        return estudanteRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscar(@PathVariable Long id) {
        return estudanteRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Map<String,Object> body) {
        try {
            String nome = (String) body.get("nome");
            String email = (String) body.get("email");
            String nascimento = (String) body.get("nascimento");
            int ano = Integer.parseInt(body.get("anoIngresso").toString());
            Long areaId = body.get("areaId") == null ? null : Long.valueOf(body.get("areaId").toString());
            
            Area area = areaId == null ? null : areaRepo.findById(areaId).orElse(null);
            
            Estudante e = new Estudante();
            e.setNome(nome);
            e.setEmail(email);
            e.setNascimento(nascimento);
            e.setAnoIngresso(ano);
            e.setArea(area);
            
            return ResponseEntity.ok(estudanteRepo.save(e));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Map<String,Object> body) {
        return estudanteRepo.findById(id).map(existing -> {
            if (body.containsKey("nome")) existing.setNome((String) body.get("nome"));
            if (body.containsKey("email")) existing.setEmail((String) body.get("email"));
            if (body.containsKey("nascimento")) existing.setNascimento((String) body.get("nascimento"));
            if (body.containsKey("anoIngresso")) existing.setAnoIngresso(Integer.parseInt(body.get("anoIngresso").toString()));
            if (body.containsKey("areaId")) {
                Long areaId = Long.valueOf(body.get("areaId").toString());
                existing.setArea(areaRepo.findById(areaId).orElse(null));
            }
            return ResponseEntity.ok(estudanteRepo.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (estudanteRepo.existsById(id)) {
            estudanteRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}