package com.progsist2.projeto.webservice_empresas_estudantes_vagas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(length = 2000)
    private String descricao;

    private LocalDate publicacao;

    private boolean ativo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private Area area;

    public Vaga() { }

    public Vaga(Long id, String titulo, String descricao, LocalDate publicacao, boolean ativo, Empresa empresa, Area area) {
        this.id = id; this.titulo = titulo; this.descricao = descricao; this.publicacao = publicacao; this.ativo = ativo; this.empresa = empresa; this.area = area;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getPublicacao() { return publicacao; }
    public void setPublicacao(LocalDate publicacao) { this.publicacao = publicacao; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }
}
