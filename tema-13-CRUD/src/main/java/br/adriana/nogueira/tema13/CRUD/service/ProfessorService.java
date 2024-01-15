package br.adriana.nogueira.tema13.CRUD.service;

import br.adriana.nogueira.tema13.CRUD.model.Professor;
import br.adriana.nogueira.tema13.CRUD.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor criarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }


    public boolean deletarProfessor(Long id) {
        professorRepository.deleteById(id);
        return true;
    }

    public Professor atualizarProfessor(Long id, Professor professor) {
        Optional<Professor> professorExistente = professorRepository.findById(id);
        if (professorExistente.isPresent()) {
            Professor professorAtual = professorExistente.get();
            professorAtual.setNome(professor.getNome());
            professorAtual.setEmail(professor.getEmail());
            professorAtual.setTelefone(professor.getTelefone());

            return professorRepository.save(professorAtual);
        } else {
            return null;
        }
    }
}
