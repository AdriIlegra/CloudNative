package br.adriana.nogueira.tema13.CRUD.service;
import br.adriana.nogueira.tema13.CRUD.model.Curso;
import br.adriana.nogueira.tema13.CRUD.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso atualizarCurso(Long id, Curso curso) {
        Curso cursoParaAtualizar = cursoRepository.findById(id).orElse(null);
        cursoParaAtualizar.setNome(curso.getNome());
        cursoParaAtualizar.setNumero_identificacao(curso.getNumero_identificacao());
        return cursoRepository.save(cursoParaAtualizar);
    }


}
