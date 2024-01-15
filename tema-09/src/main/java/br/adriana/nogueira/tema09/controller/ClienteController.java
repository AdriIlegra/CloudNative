package br.adriana.nogueira.tema09.controller;
import br.adriana.nogueira.tema09.model.Cliente;
import br.adriana.nogueira.tema09.service.ClienteService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso"),
})
public class ClienteController {

    private ClienteController clienteController;

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> buscarTodosClientes(){
        List<Cliente> clientes = clienteService.buscarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        Cliente clienteAtualizado = clienteService.atualizarCliente(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClientePorId(@PathVariable Long id){
        clienteService.deletarClientePorId(id);
        return ResponseEntity.noContent().build();
    }



}





