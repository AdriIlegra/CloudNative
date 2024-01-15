package br.adriana.nogueira.tema05.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TabelaPrecos {

    private static final Map<String, Double> tabelaPrecos = new HashMap<>();

    static {
        tabelaPrecos.put("onibus", 1.59);
        tabelaPrecos.put("moto", 1.0);
        tabelaPrecos.put("bike", 49.0);
        tabelaPrecos.put("caminhao", 3.95);
        tabelaPrecos.put("fusca", 2.11);
    }

    public Map<String, Double> getPrecos() {
        return tabelaPrecos;
    }

    public double getPreco(String tipoVeiculo) {
        return tabelaPrecos.getOrDefault(tipoVeiculo, 0.0);
    }


    public void removePreco(String tipoVeiculo) {
        tabelaPrecos.remove(tipoVeiculo);
    }

    public void limpaPrecos() {
        tabelaPrecos.clear();
    }

    public void atualizaPrecos(Map<String, Double> precos) {
        tabelaPrecos.putAll(precos);
    }


    public void setPrecos(Map<String, Double> tabelaPrecos) {
        tabelaPrecos.putAll(tabelaPrecos);
    }

    public void adicionaPreco(String tipoVeiculo, Double preco) {
        tabelaPrecos.put(tipoVeiculo, preco);


    }

    public void atualizaPreco(String tipoVeiculo, Double preco) {
        tabelaPrecos.put(tipoVeiculo, preco);

    }

    public int getAdicionalPorEixo() {
        return 0;
    }

}