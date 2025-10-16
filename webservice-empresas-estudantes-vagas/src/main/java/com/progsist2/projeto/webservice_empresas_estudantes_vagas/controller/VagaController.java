package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.web.bind.annotation.*;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Vaga;
import java.util.*;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private List<Vaga> vagas = new ArrayList<>(Arrays.asList(
        new Vaga(1, "Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", "2025-10-01", true, 1),
        new Vaga(2, "Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", "2025-09-27", true, 2),
        new Vaga(3, "Engenheiro de Software", "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", "2025-10-03", false, 3),
        new Vaga(4, "Analista de Dados", "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true, 4),
        new Vaga(5, "Designer Digital", "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", "2025-09-30", false, 5),
        new Vaga(6, "Consultor de Projetos", "Elaboração e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, 1),
        new Vaga(7, "Programador Full Stack", "Desenvolvimento de aplicações web frontend e backend com foco em automação.", "2025-10-04", true, 2)
    ));

    @GetMapping
    public List<Vaga> getAll() {
        return vagas;
    }

    @GetMapping("/<built-in function id>")
    public Vaga getById(@PathVariable int id) {
        return vagas.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Vaga create(@RequestBody Vaga vaga) {
        vagas.add(vaga);
        return vaga;
    }

    @PutMapping("/<built-in function id>")
    public Vaga update(@PathVariable int id, @RequestBody Vaga novo) {
        Vaga v = getById(id);
        if (v != null) {
            v.setTitulo(novo.getTitulo());
            v.setDescricao(novo.getDescricao());
            v.setPublicacao(novo.getPublicacao());
            v.setAtivo(novo.isAtivo());
            v.setIdEmpresa(novo.getIdEmpresa());
        }
        return v;
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable int id) {
        vagas.removeIf(v -> v.getId() == id);
    }
}
