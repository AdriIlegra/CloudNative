package br.adriana.nogueira.tema05.controller;


import br.adriana.nogueira.tema05.model.TabelaPrecos;
import br.adriana.nogueira.tema05.model.Troco;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/troco")
public class TrocoController {


    private Troco troco;

    public TrocoController(Troco troco) {
        this.troco = troco;
    }

    @PostMapping("/calcular")
    public Troco calcularTroco(@RequestBody Map<String, Object> pagamento) {
        double valorPagamento = Double.parseDouble(pagamento.get("valor").toString());
        String tipoVeiculo = pagamento.get("tipoVeiculo").toString();
        int quantidadeEixos = Integer.parseInt(pagamento.get("quantidadeEixos").toString());

        TabelaPrecos tabelaPrecos = new TabelaPrecos();
        double valorTarifa = tabelaPrecos.getPreco(tipoVeiculo);

        if (valorTarifa == 0) {
            throw new IllegalArgumentException("Veículo não encontrado na tabela de preços.");
        }

        double valorTotal = valorTarifa + (quantidadeEixos * tabelaPrecos.getAdicionalPorEixo());
        double troco = valorPagamento - valorTotal;

        if (troco < 0) {
            throw new IllegalArgumentException("O valor do pagamento é insuficiente.");
        }

        return new Troco(valorPagamento, valorTotal, troco);
    }
}