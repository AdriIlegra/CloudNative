package br.adriana.nogueira.tema08.controller;
import br.adriana.nogueira.tema08.model.CalculoHistorico;
import br.adriana.nogueira.tema08.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
public class CalculadoraController {

    private final CalculadoraService service;

    @Autowired
    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/soma")
    public Mono<CalculoHistorico> soma(@RequestParam("primeiroValor") int primeiroValor,
                                       @RequestParam("segundoValor") int segundoValor) {
        return service.soma(primeiroValor, segundoValor)
                .flatMap(resultado -> service.salvarHistorico(new CalculoHistorico(
                        "Soma: " + primeiroValor + " + " + segundoValor, resultado
                )))
                .map(calculoHistorico -> new CalculoHistorico(
                        calculoHistorico.getOperacao(), calculoHistorico.getResultado()
                ));
    }

    @GetMapping("/subtracao")
    public Mono<CalculoHistorico> subtracao(@RequestParam("primeiroValor") int primeiroValor,
                                            @RequestParam("segundoValor") int segundoValor) {
        return service.subtracao(primeiroValor, segundoValor)
                .flatMap(resultado -> service.salvarHistorico(new CalculoHistorico(
                        "Subtração: " + primeiroValor + " - " + segundoValor, resultado
                )))
                .map(calculoHistorico -> new CalculoHistorico(
                        calculoHistorico.getOperacao(), calculoHistorico.getResultado()
                ));
    }

    @GetMapping("/divisao")
    public Mono<CalculoHistorico> divisao(@RequestParam("primeiroValor") int primeiroValor,
                                          @RequestParam("segundoValor") int segundoValor) {
        return service.divisao(primeiroValor, segundoValor)
                .flatMap(resultado -> service.salvarHistorico(new CalculoHistorico(
                        "Divisão: " + primeiroValor + " / " + segundoValor, resultado
                )))
                .map(calculoHistorico -> new CalculoHistorico(
                        calculoHistorico.getOperacao(), calculoHistorico.getResultado()
                ));
    }

    @GetMapping("/mutiplicacao")
    public Mono<CalculoHistorico> mutiplicacao(@RequestParam("primeiroValor") int primeiroValor,
                                               @RequestParam("segundoValor") int segundoValor) {
        return service.multiplicacao(primeiroValor, segundoValor)
                .flatMap(resultado -> service.salvarHistorico(new CalculoHistorico(
                        "Multiplicação: " + primeiroValor + " * " + segundoValor, resultado
                )))
                .map(calculoHistorico -> new CalculoHistorico(
                        calculoHistorico.getOperacao(), calculoHistorico.getResultado()
                ));
    }

    @GetMapping("/potencia")
    public Mono<CalculoHistorico> potencia(@RequestParam("primeiroValor") double primeiroValor,
                                           @RequestParam("segundoValor") double segundoValor) {
        return service.potencia(primeiroValor, segundoValor)
                .flatMap(resultado -> service.salvarHistorico(new CalculoHistorico(
                        "Potência: " + primeiroValor + " ^ " + segundoValor, resultado
                )))
                .map(calculoHistorico -> new CalculoHistorico(
                        calculoHistorico.getOperacao(), calculoHistorico.getResultado()
                ));
    }

    @GetMapping("/raizquadrada")
    public Mono<CalculoHistorico> raizQuadra(@RequestParam("valor") double valor) {
        return service.raizQuadrada(valor)
                .flatMap(resultado -> service.salvarHistorico(new CalculoHistorico(
                        "Raiz Quadrada de " + valor, resultado
                )))
                .map(calculoHistorico -> new CalculoHistorico(
                        calculoHistorico.getOperacao(), calculoHistorico.getResultado()
                ));
    }

}