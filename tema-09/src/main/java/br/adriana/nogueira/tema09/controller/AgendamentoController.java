package br.adriana.nogueira.tema09.controller;
import br.adriana.nogueira.tema09.model.Agendamento;
import br.adriana.nogueira.tema09.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<Agendamento> agendar(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.agendar(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desmarcar(@PathVariable Long id) {
        agendamentoService.desmarcar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Agendamento>> buscarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }
}
