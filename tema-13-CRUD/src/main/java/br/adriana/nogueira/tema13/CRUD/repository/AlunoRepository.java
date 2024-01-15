package br.adriana.nogueira.tema13.CRUD.repository;


import br.adriana.nogueira.tema13.CRUD.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
