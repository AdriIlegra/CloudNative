package br.adriana.nogueira.tema05.service;

import br.adriana.nogueira.tema05.model.Pagamento;
import br.adriana.nogueira.tema05.model.TabelaPrecos;
import br.adriana.nogueira.tema05.model.Troco;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PedagioService {

    private static final Map<String, Double> tabelaPrecos = new HashMap<>();

    static {
        tabelaPrecos.put("onibus", 1.59);
        tabelaPrecos.put("moto", 1.0);
        tabelaPrecos.put("bike", 49.0);
        tabelaPrecos.put("caminhao", 3.95);
        tabelaPrecos.put("fusca", 2.11);
    }

    public TabelaPrecos getTabelaPrecos() {
        TabelaPrecos tabela = new TabelaPrecos();
        tabela.setPrecos(tabelaPrecos);
        return tabela;
    }

    public Troco processarPagamento(Pagamento pagamento) {
        double preco = tabelaPrecos.getOrDefault(pagamento.getTipoVeiculo(), 0.0);
        double valorTroco = pagamento.getValor() - preco;

        Troco troco = new Troco();
        troco.setValorTroco(valorTroco);
        return troco;
    }

}
