package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.web.bind.annotation.*;
import com.progsist2.projeto.model.Estudante;
import java.util.*;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>(Arrays.asList(
        new Estudante(1, "Ana Paula Souza", "ana.souza@email.com", "2002-03-15", 2020),
        new Estudante(2, "Carlos Henrique Lima", "carlos.lima@email.com", "2001-10-22", 2019),
        new Estudante(3, "Fernanda Oliveira", "fernanda.oliveira@email.com", "2003-07-05", 2021),
        new Estudante(4, "Lucas Pereira", "lucas.pereira@email.com", "2002-04-11", 2020),
        new Estudante(5, "Gabriela Martins", "gabriela.martins@email.com", "2001-12-25", 2019),
        new Estudante(6, "Rafael Costa", "rafael.costa@email.com", "2000-09-13", 2018),
        new Estudante(7, "Juliana Silva", "juliana.silva@email.com", "2002-06-18", 2020),
        new Estudante(8, "Marcos Vinícius", "marcos.vinicius@email.com", "2003-01-30", 2021),
        new Estudante(9, "Camila Azevedo", "camila.azevedo@email.com", "2001-11-08", 2019),
        new Estudante(10, "Felipe Cardoso", "felipe.cardoso@email.com", "2000-08-27", 2018)
    ));

    @GetMapping
    public List<Estudante> getAll() {
        return estudantes;
    }

    @GetMapping("/<built-in function id>")
    public Estudante getById(@PathVariable int id) {
        return estudantes.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Estudante create(@RequestBody Estudante estudante) {
        estudantes.add(estudante);
        return estudante;
    }

    @PutMapping("/<built-in function id>")
    public Estudante update(@PathVariable int id, @RequestBody Estudante novo) {
        Estudante est = getById(id);
        if (est != null) {
            est.setNome(novo.getNome());
            est.setEmail(novo.getEmail());
            est.setNascimento(novo.getNascimento());
            est.setAnoIngresso(novo.getAnoIngresso());
        }
        return est;
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable int id) {
        estudantes.removeIf(e -> e.getId() == id);
    }
}
