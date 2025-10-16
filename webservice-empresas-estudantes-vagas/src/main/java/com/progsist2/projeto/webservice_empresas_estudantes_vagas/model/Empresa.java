package com.progsist2.projeto.model;

public class Empresa {
    private int id;
    private String nome;
    private String cnpj;
    private String emailContato;

    public Empresa() {}

    public Empresa(int id, String nome, String cnpj, String emailContato) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.emailContato = emailContato;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getEmailContato() { return emailContato; }
    public void setEmailContato(String emailContato) { this.emailContato = emailContato; }
}
