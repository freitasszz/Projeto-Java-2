package com.progsist2.projeto.webservice_empresas_estudantes_vagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Vaga;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository.VagaRepo;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private List<Vaga> vagas = new ArrayList<>();

    public VagaController() {
        vagas.add(new Vaga(1, "Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", "2025-10-01", true, 1));
        vagas.add(new Vaga(2, "Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", "2025-09-27", true, 2));
        vagas.add(new Vaga(3, "Engenheiro de Software", "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", "2025-10-03", false, 3));
        vagas.add(new Vaga(4, "Analista de Dados", "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true, 4));
        vagas.add(new Vaga(5, "Designer Digital", "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", "2025-09-30", false, 5));
        vagas.add(new Vaga(6, "Consultor de Projetos", "Elaboração e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, 1));
        vagas.add(new Vaga(7, "Programador Full Stack", "Desenvolvimento de aplicações web frontend e backend com foco em automação.", "2025-10-04", true, 2));
    }

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
