package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.web.bind.annotation.*;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Empresa;
import java.util.*;

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

    @GetMapping
    public List<Empresa> getAll() {
        return empresas;
    }

    @GetMapping("/<built-in function id>")
    public Empresa getById(@PathVariable int id) {
        return empresas.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) {
        empresas.add(empresa);
        return empresa;
    }

    @PutMapping("/<built-in function id>")
    public Empresa update(@PathVariable int id, @RequestBody Empresa nova) {
        Empresa emp = getById(id);
        if (emp != null) {
            emp.setNome(nova.getNome());
            emp.setCnpj(nova.getCnpj());
            emp.setEmailContato(nova.getEmailContato());
        }
        return emp;
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable int id) {
        empresas.removeIf(e -> e.getId() == id);
    }
}
