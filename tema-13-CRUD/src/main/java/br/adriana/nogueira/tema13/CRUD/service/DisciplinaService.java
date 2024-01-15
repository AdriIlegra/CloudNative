package br.adriana.nogueira.tema13.CRUD.service;

import br.adriana.nogueira.tema13.CRUD.model.Disciplina;
import br.adriana.nogueira.tema13.CRUD.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina criarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    public void deletarDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public Disciplina atualizarDisciplina(Long id, Disciplina disciplina) {
        Disciplina disciplinaExistente = disciplinaRepository.findById(id).orElse(null);
        if (disciplinaExistente != null) {
            disciplinaExistente.setNome(disciplina.getNome());
            disciplinaExistente.setCargaHoraria(disciplina.getCargaHoraria());
            disciplinaExistente.setCodigo(disciplina.getCodigo());
            disciplinaExistente.setSala(disciplina.getSala());
            return disciplinaRepository.save(disciplinaExistente);
        }
        return null;
    }
}
