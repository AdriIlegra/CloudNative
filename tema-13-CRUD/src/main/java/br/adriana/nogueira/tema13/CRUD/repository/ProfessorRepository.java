package br.adriana.nogueira.tema13.CRUD.repository;

import br.adriana.nogueira.tema13.CRUD.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
