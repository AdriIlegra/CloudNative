package br.adriana.nogueira.tema09.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "horario_inicio", nullable = false)
    private LocalDateTime horarioInicio;

    @Column(name = "horario_fim", nullable = false)
    private LocalDateTime horarioFim;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "data_hora_agendamento", nullable = false)
    private LocalDateTime dataHoraAgendamento;

    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
