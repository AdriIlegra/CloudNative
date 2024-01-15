package br.adriana.nogueira.tema13.CRUD.model;

import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;

    @Column(name = "numero_identificacao")
    private String numero_identificacao;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero_identificacao() {
        return numero_identificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero_identificacao(String numero_identificacao) {
        this.numero_identificacao = numero_identificacao;
    }
}




