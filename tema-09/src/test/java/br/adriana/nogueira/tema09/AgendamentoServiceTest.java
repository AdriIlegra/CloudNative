package br.adriana.nogueira.tema09;

import br.adriana.nogueira.tema09.model.Agendamento;
import br.adriana.nogueira.tema09.model.Cliente;
import br.adriana.nogueira.tema09.repository.AgendamentoRepository;
import br.adriana.nogueira.tema09.service.AgendamentoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AgendamentoServiceTest {

    @Autowired
    private AgendamentoService agendamentoService;

    @MockBean
    private AgendamentoRepository agendamentoRepository;

    @Test
    void agendar_deveRetornarNovoAgendamento() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Fulano");
        cliente.setTelefone("123456789");
        cliente.setCpf("12345678900");
        cliente.setRg("1234567");

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setHorarioInicio(LocalDateTime.of(2023, 8, 15, 10, 0));
        agendamento.setHorarioFim(LocalDateTime.of(2023, 8, 15, 11, 0));
        agendamento.setData(LocalDate.of(2023, 8, 15));


        Mockito.when(agendamentoRepository.save(Mockito.any(Agendamento.class))).thenReturn(agendamento);

        Agendamento novoAgendamento = agendamentoService.agendar(agendamento);

        assertNotNull(novoAgendamento);
        assertEquals(cliente, novoAgendamento.getCliente());
        assertEquals(LocalDateTime.of(2023, 8, 15, 10, 0), novoAgendamento.getHorarioInicio());
        assertEquals(LocalDateTime.of(2023, 8, 15, 11, 0), novoAgendamento.getHorarioFim());
        assertEquals(LocalDate.of(2023, 8, 15), novoAgendamento.getData());
    }
}
