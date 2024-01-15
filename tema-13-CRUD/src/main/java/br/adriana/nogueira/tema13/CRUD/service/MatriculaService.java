package br.adriana.nogueira.tema13.CRUD.service;

import br.adriana.nogueira.tema13.CRUD.model.Disciplina;
import br.adriana.nogueira.tema13.CRUD.model.Matricula;
import br.adriana.nogueira.tema13.CRUD.model.NotaAluno;
import br.adriana.nogueira.tema13.CRUD.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    @Autowired
    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula criarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarMatriculaPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public void deletarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }

    public Matricula atualizarMatricula(Long id, Matricula matricula) {
        Matricula matriculaExistente = matriculaRepository.findById(id).orElse(null);
        if (matriculaExistente != null) {
            matriculaExistente.setAluno(matricula.getAluno());
            matriculaExistente.setDisciplina(matricula.getDisciplina());
            matriculaExistente.setNota(matricula.getNota());
            return matriculaRepository.save(matriculaExistente);
        }
        return null;
    }

    public Map<Disciplina, List<NotaAluno>> listarNotasPorDisciplina() {
        List<Matricula> matriculas = matriculaRepository.findAll();
        Map<Disciplina, List<NotaAluno>> notasPorDisciplina = new HashMap<>();

        for (Matricula matricula : matriculas) {
            Disciplina disciplina = matricula.getDisciplina();
            NotaAluno notaAluno = new NotaAluno(matricula.getAluno(), matricula.getNota());

            notasPorDisciplina.computeIfAbsent(disciplina, k -> new ArrayList<>()).add(notaAluno);
        }

        return notasPorDisciplina;
    }
}

