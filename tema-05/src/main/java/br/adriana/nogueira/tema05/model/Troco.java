package br.adriana.nogueira.tema05.model;

import org.springframework.stereotype.Component;

@Component
public class Troco {
    private double valorTroco;

    public Troco(double valorPagamento, double valorTotal, double troco) {

    }

    public Troco() {

    }
    // Getters e setters

    public double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(double valorTroco) {
        this.valorTroco = valorTroco;
    }
}

