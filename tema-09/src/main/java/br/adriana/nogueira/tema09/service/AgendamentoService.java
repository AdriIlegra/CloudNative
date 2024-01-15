package br.adriana.nogueira.tema09.service;
import br.adriana.nogueira.tema09.model.Agendamento;
import br.adriana.nogueira.tema09.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento agendar(Agendamento agendamento) {
        agendamento.setDataHoraAgendamento(LocalDateTime.now());

        return agendamentoRepository.save(agendamento);
    }

    public void desmarcar(Long agendamentoId) {
        agendamentoRepository.deleteById(agendamentoId);
    }

    public Optional<Agendamento> buscarAgendamentoPorId(Long agendamentoId) {
        return agendamentoRepository.findById(agendamentoId);
    }

    public List<Agendamento> buscarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }
}
