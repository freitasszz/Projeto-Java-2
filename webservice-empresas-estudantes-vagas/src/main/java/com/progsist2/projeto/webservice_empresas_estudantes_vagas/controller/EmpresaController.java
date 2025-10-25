package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Empresa;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.EmpresaRepo;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private List<Empresa> empresas = new ArrayList<>(Arrays.asList(
        new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"),
        new Empresa(2, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"),
        new Empresa(3, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"),
        new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"),
        new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com")
    ));

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
