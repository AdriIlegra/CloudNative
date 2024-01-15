package br.adriana.nogueira.rest_maven.model;


import java.util.concurrent.atomic.AtomicInteger;

public enum TipoVeiculo {
    ONIBUS("Onibus", 2.0),
    MOTO("Moto", 1.0),
    BICICLETA("Bicicleta", 0.49),
    CAMINHAO("Caminhão", 3.95, 1.5),  // Adiciona o valor adicional de eixo para caminhão
    FUSCA("Fusca", 2.11);

    private static final AtomicInteger nextId = new AtomicInteger(1);
    private String nome;
    private double precoBase;
    private double valorAdicionalEixo;

    TipoVeiculo(String nome, double precoBase) {
        this(nome, precoBase, 0);
    }

    TipoVeiculo(String nome, double precoBase, double valorAdicionalEixo) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.valorAdicionalEixo = valorAdicionalEixo;

    }

    // Getters e Setters

    public String getNome() {

        return nome;
    }

    public double getPrecoBase() {

        return precoBase;
    }

    public double getValorAdicionalEixo() {

        return valorAdicionalEixo;
    }

    public void setPrecoBase(double precoBase) {

        this.precoBase = precoBase;
    }

    public void setValorAdicionalEixo(double valorAdicionalEixo) {

        this.valorAdicionalEixo = valorAdicionalEixo;
    }
}
