package br.adriana.nogueira.rest_maven.controller;

import br.adriana.nogueira.rest_maven.model.TipoVeiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedagio")
public class PedagioController {

    @GetMapping("/{tipo}")
    public ResponseEntity<String> obterPrecoBase(@PathVariable String tipo) {
        TipoVeiculo veiculo = TipoVeiculo.valueOf(tipo.toUpperCase());
        double precoBase = veiculo.getPrecoBase();
        String mensagem = " Preço base do veiculo " + veiculo.getNome()  + " é "  +  precoBase;
        return ResponseEntity.ok(mensagem);
    }

    @PostMapping("/{tipo}")
    public ResponseEntity<String>atualizarPrecoBase(@PathVariable String tipo, @RequestParam double preco) {
        TipoVeiculo veiculo = TipoVeiculo.valueOf(tipo.toUpperCase());
        veiculo.setPrecoBase(preco);
        String mensagem = "Preço base do veiculo " + veiculo.getNome() + "atualizad para" + preco;
        return ResponseEntity.ok(mensagem);
    }


    @GetMapping("/listar")
    public ResponseEntity< List<String>> listarVeiculos() {
        List<String> veiculos = new ArrayList<>();
        for (TipoVeiculo veiculo : TipoVeiculo.values()) {
            veiculos.add("Tipo: " + veiculo.getNome() + ", Preço Base: " + veiculo.getPrecoBase());
        }
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping("/pagamento/{tipo}")
    public ResponseEntity<String> pagarPedagio(@PathVariable String tipo, @RequestParam double valorPago) {
        TipoVeiculo veiculo = TipoVeiculo.valueOf(tipo.toUpperCase());
        double precoBase = veiculo.getPrecoBase();
        double valorAdicionalEixo = veiculo.getValorAdicionalEixo();
        double precoTotal = precoBase + valorAdicionalEixo;

        if (valorPago >= precoTotal) {
            double troco = valorPago - precoTotal;
            String mensagem = "Pagamento bem-sucedido! Troco: " + troco;
            return ResponseEntity.ok(mensagem);
        } else {
            String mensagem = "Pagamento insuficiente. Valor necessário: " + precoTotal;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
    }
}






