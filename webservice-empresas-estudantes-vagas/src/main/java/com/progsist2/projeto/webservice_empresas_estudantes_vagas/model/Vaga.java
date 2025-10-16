package com.progsist2.projeto.webservice_empresas_estudantes_vagas.model;

public class Vaga {
    private int id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private boolean ativo;
    private int idEmpresa;

    public Vaga() {}

    public Vaga(int id, String titulo, String descricao, String publicacao, boolean ativo, int idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.idEmpresa = idEmpresa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getPublicacao() { return publicacao; }
    public void setPublicacao(String publicacao) { this.publicacao = publicacao; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
}
