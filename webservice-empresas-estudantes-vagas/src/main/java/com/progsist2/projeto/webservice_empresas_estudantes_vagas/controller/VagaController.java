package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Vaga;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.VagaRepo;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    

    @Autowired
    private VagaRepo repo;

    @GetMapping
    public List<Vaga> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Vaga adicionar(@RequestBody Vaga vaga) {
        return repo.save(vaga);
    }

    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga vaga) {
        vaga.setId(id);
        return repo.save(vaga);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
