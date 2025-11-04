package com.progsist2.projeto.webservice_empresas_estudantes_vagas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inscricao")
    private LocalDate dataInscricao;

    private String status;

    @Column(name = "mensagem_apresentacao", length = 2000)
    private String mensagemApresentacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaga_id")
    private VagaEstagio vaga;

    public Inscricao() {}
    public Inscricao(Long id, LocalDate dataInscricao, String status, String mensagemApresentacao, Estudante estudante, VagaEstagio vaga) {
        this.id = id; this.dataInscricao = dataInscricao; this.status = status; this.mensagemApresentacao = mensagemApresentacao; this.estudante = estudante; this.vaga = vaga;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(LocalDate dataInscricao) { this.dataInscricao = dataInscricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMensagemApresentacao() { return mensagemApresentacao; }
    public void setMensagemApresentacao(String mensagemApresentacao) { this.mensagemApresentacao = mensagemApresentacao; }
    public Estudante getEstudante() { return estudante; }
    public void setEstudante(Estudante estudante) { this.estudante = estudante; }
    public VagaEstagio getVaga() { return vaga; }
    public void setVaga(VagaEstagio vaga) { this.vaga = vaga; }
}
