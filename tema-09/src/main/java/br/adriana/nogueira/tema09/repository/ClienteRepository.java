package br.adriana.nogueira.tema09.repository;

import br.adriana.nogueira.tema09.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAll();

    void deleteById(Long id);

    Cliente save(Cliente cliente
    );

    Optional<Cliente> findById(Long id);
}
