package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Estudante;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.EstudanteRepo;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>();

    public EstudanteController() {
        estudantes.add(new Estudante(1, "Ana Paula Souza", "ana.souza@email.com", "2002-03-15", 2020));
        estudantes.add(new Estudante(2, "Carlos Henrique Lima", "carlos.lima@email.com", "2001-10-22", 2019));
        estudantes.add(new Estudante(3, "Fernanda Oliveira", "fernanda.oliveira@email.com", "2003-07-05", 2021));
        estudantes.add(new Estudante(4, "Lucas Pereira", "lucas.pereira@email.com", "2002-04-11", 2020));
        estudantes.add(new Estudante(5, "Gabriela Martins", "gabriela.martins@email.com", "2001-12-25", 2019));
        estudantes.add(new Estudante(6, "Rafael Costa", "rafael.costa@email.com", "2000-09-13", 2018));
        estudantes.add(new Estudante(7, "Juliana Silva", "juliana.silva@email.com", "2002-06-18", 2020));
        estudantes.add(new Estudante(8, "Marcos Vinicius", "marcos.vinicius@email.com", "2003-01-30", 2021));
        estudantes.add(new Estudante(9, "Camila Azevedo", "camila.azevedo@email.com", "2001-11-08", 2019));
        estudantes.add(new Estudante(10, "Felipe Cardoso", "felipe.cardoso@email.com", "2000-08-27", 2018));
    }

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
