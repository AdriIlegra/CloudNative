package br.adriana.nogueira.tema08.service;
import br.adriana.nogueira.tema08.model.CalculoHistorico;
import br.adriana.nogueira.tema08.repository.CalculadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CalculadoraService {

    private final CalculadoraRepository historicoRepository;

    @Autowired
    public CalculadoraService(CalculadoraRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public Mono<String> soma(int primeiroValor, int segundoValor) {
        int resultado = primeiroValor + segundoValor;
        return Mono.just(Integer.toString(resultado));
    }

    public Mono<String> subtracao(int primeiroValor, int segundoValor) {
        int resultado = primeiroValor - segundoValor;
        return Mono.just(Integer.toString(resultado));
    }

    public Mono<String> divisao(int primeiroValor, int segundoValor) {
        double resultado = (double) primeiroValor / segundoValor;
        return Mono.just(Double.toString(resultado));
    }

    public Mono<String> multiplicacao(int primeiroValor, int segundoValor) {
        double resultado = (double) primeiroValor * segundoValor;
        return Mono.just(Double.toString(resultado));
    }

    public Mono<String> potencia(double primeiroValor, double segundoValor) {
        double resultado = Math.pow(primeiroValor, segundoValor);
        return Mono.just(Double.toString(resultado));
    }

    public Mono<String> raizQuadrada(double valor) {
        double resultado = Math.sqrt(valor);
        return Mono.just(Double.toString(resultado));
    }

    public Mono<CalculoHistorico> salvarHistorico(CalculoHistorico historico) {
        return historicoRepository.save(historico);
    }
}