package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Empresa;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.EmpresaRepo;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    

    @Autowired
    private EmpresaRepo repo;

    @GetMapping
    public List<Empresa> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Empresa adicionar(@RequestBody Empresa empresa) {
        return repo.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        return repo.save(empresa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
