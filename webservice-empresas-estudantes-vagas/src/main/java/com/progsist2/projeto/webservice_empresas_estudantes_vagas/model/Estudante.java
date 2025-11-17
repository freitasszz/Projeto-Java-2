package com.progsist2.projeto.webservice_empresas_estudantes_vagas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudante")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String nascimento;

    @Column(name = "ano_ingresso")
    private int anoIngresso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private Area area;

    public Estudante() { }

    public Estudante(Long id, String nome, String email, String nascimento, int anoIngresso, Area area) {
        this.id = id; this.nome = nome; this.email = email; this.nascimento = nascimento; this.anoIngresso = anoIngresso; this.area = area;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNascimento() { return nascimento; }
    public void setNascimento(String nascimento) { this.nascimento = nascimento; }
    public int getAnoIngresso() { return anoIngresso; }
    public void setAnoIngresso(int anoIngresso) { this.anoIngresso = anoIngresso; }
    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }
}
