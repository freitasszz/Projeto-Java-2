package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.*;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepo inscricaoRepo;

    @Autowired
    private EstudanteRepo estudanteRepo;

    @Autowired
    private VagaEstagioRepo vagaRepo;

    @GetMapping
    public List<Inscricao> listar() { return inscricaoRepo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscar(@PathVariable Long id) {
        return inscricaoRepo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * body:
     * { "estudanteId":1, "vagaId":1, "mensagemApresentacao":"..." }
     */
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Map<String,String> body) {
        try {
            Long estudanteId = Long.valueOf(body.get("estudanteId"));
            Long vagaId = Long.valueOf(body.get("vagaId"));
            String mensagem = body.getOrDefault("mensagemApresentacao", "");

            Estudante estudante = estudanteRepo.findById(estudanteId).orElse(null);
            VagaEstagio vaga = vagaRepo.findById(vagaId).orElse(null);
            if (estudante == null || vaga == null) return ResponseEntity.badRequest().body("Estudante ou Vaga não encontrado");

            Inscricao i = new Inscricao();
            i.setDataInscricao(LocalDate.now());
            i.setStatus("PENDENTE");
            i.setMensagemApresentacao(mensagem);
            i.setEstudante(estudante);
            i.setVaga(vaga);

            Inscricao salvo = inscricaoRepo.save(i);
            return ResponseEntity.created(URI.create("/inscricoes/" + salvo.getId())).body(salvo);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (inscricaoRepo.existsById(id)) { inscricaoRepo.deleteById(id); return ResponseEntity.noContent().build(); }
        return ResponseEntity.notFound().build();
    }
}
