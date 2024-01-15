package br.adriana.nogueira.tema09.repository;
import br.adriana.nogueira.tema09.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
