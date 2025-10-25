package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Estudante;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.EstudanteRepo;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    

    @Autowired
    private EstudanteRepo repo;

    @GetMapping
    public List<Estudante> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Estudante adicionar(@RequestBody Estudante estudante) {
        return repo.save(estudante);
    }

    @PutMapping("/{id}")
    public Estudante atualizar(@PathVariable Long id, @RequestBody Estudante estudante) {
        estudante.setId(id);
        return repo.save(estudante);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
