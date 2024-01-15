package br.adriana.nogueira.tema05.controller;

import br.adriana.nogueira.tema05.model.TabelaPrecos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tabela-precos")
public class TabelaPrecosController {
    private TabelaPrecos tabelaPrecos;

    public TabelaPrecosController(TabelaPrecos tabelaPrecos) {
        this.tabelaPrecos = tabelaPrecos;
    }


    @GetMapping("/listar")
    public TabelaPrecos listarTabelaPrecos() {
        return tabelaPrecos;
    }


}

