package br.adriana.nogueira.tema08.repository;
import br.adriana.nogueira.tema08.model.CalculoHistorico;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculadoraRepository extends ReactiveMongoRepository<CalculoHistorico, String> {
}
