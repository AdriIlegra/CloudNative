package br.adriana.nogueira.tema09.service;
import br.adriana.nogueira.tema09.model.Cliente;
import br.adriana.nogueira.tema09.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService{

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClientePorId(Long id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

    public Cliente atualizarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deletarClientePorId(Long id){
        clienteRepository.deleteById(id);
    }



}