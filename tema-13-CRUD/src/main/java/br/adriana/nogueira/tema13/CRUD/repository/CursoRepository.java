package br.adriana.nogueira.tema13.CRUD.repository;

import br.adriana.nogueira.tema13.CRUD.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
