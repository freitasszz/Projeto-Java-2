package com.progsist2.projeto.model;

public class Estudante {
    private int id;
    private String nome;
    private String email;
    private String nascimento;
    private int anoIngresso;

    public Estudante() {}

    public Estudante(int id, String nome, String email, String nascimento, int anoIngresso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.anoIngresso = anoIngresso;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNascimento() { return nascimento; }
    public void setNascimento(String nascimento) { this.nascimento = nascimento; }
    public int getAnoIngresso() { return anoIngresso; }
    public void setAnoIngresso(int anoIngresso) { this.anoIngresso = anoIngresso; }
}
