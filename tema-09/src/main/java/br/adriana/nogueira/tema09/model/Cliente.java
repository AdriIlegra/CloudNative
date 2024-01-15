package br.adriana.nogueira.tema09.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 100)
    private String telefone;

    @Column(name = "cpf", nullable = false, length = 100)
    private String cpf;

    @Column(name = "rg", nullable = false, length = 100)
    private String rg;



    // Exemplo de valor para o modelo Cliente
    public static Cliente exemplo() {
        Cliente cliente = new Cliente();
        cliente.setNome("Fulano de Tal");
        cliente.setTelefone("(11) 99999-9999");
        cliente.setCpf("123.456.789-10");
        cliente.setRg("987654321");
        return cliente;
    }
}
