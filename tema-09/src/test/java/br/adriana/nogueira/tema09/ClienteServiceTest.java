package br.adriana.nogueira.tema09;

import br.adriana.nogueira.tema09.model.Cliente;
import br.adriana.nogueira.tema09.repository.ClienteRepository;
import br.adriana.nogueira.tema09.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    void criarCliente_deveRetornarNovoCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Fulano");
        cliente.setTelefone("123456789");
        cliente.setCpf("12345678900");
        cliente.setRg("1234567");

        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        Cliente novoCliente = clienteService.criarCliente(cliente);

        assertNotNull(novoCliente);
        assertEquals("Fulano", novoCliente.getNome());
        assertEquals("123456789", novoCliente.getTelefone());
        assertEquals("12345678900", novoCliente.getCpf());
        assertEquals("1234567", novoCliente.getRg());
    }

    @Test
    void buscarClientePorId_deveRetornarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Fulano");
        cliente.setTelefone("123456789");
        cliente.setCpf("12345678900");
        cliente.setRg("1234567");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(java.util.Optional.of(cliente));

        Cliente clienteEncontrado = clienteService.buscarClientePorId(1L).get();

        assertNotNull(clienteEncontrado);
        assertEquals("Fulano", clienteEncontrado.getNome());
        assertEquals("123456789", clienteEncontrado.getTelefone());
        assertEquals("12345678900", clienteEncontrado.getCpf());
        assertEquals("1234567", clienteEncontrado.getRg());
    }






}
