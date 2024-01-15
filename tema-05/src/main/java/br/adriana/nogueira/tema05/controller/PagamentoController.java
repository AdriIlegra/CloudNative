package br.adriana.nogueira.tema05.controller;

import br.adriana.nogueira.tema05.model.Pagamento;
import br.adriana.nogueira.tema05.model.TabelaPrecos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private TabelaPrecos tabelaPrecos;

    @Autowired
    public PagamentoController(TabelaPrecos tabelaPrecos) {
        this.tabelaPrecos = tabelaPrecos;
    }

    @GetMapping("/listar")
    public TabelaPrecos listarTabelaPrecos() {
        return tabelaPrecos;
    }

    @PostMapping("/processar")
    public double processarPagamento(@RequestBody Pagamento pagamento) {
        double valorPagamento = pagamento.getValor();
        double valorTarifa = tabelaPrecos.getPreco(pagamento.getTipoVeiculo());
        int quantidadeEixos = pagamento.getQuantidadeEixos();

        if (valorTarifa == 0) {
            throw new IllegalArgumentException("Veículo não encontrado na tabela de preços.");
        }

        double valorTotal = valorTarifa + (quantidadeEixos * tabelaPrecos.getAdicionalPorEixo());
        double troco = valorPagamento - valorTotal;

        if (troco < 0) {
            throw new IllegalArgumentException("O valor do pagamento é insuficiente.");
        }

        return troco;
    }
}
