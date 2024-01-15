package br.adriana.nogueira.tema13.CRUD.service;

import br.adriana.nogueira.tema13.CRUD.model.Aluno;
import br.adriana.nogueira.tema13.CRUD.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }


    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistenteOptional = alunoRepository.findById(id);

        if (alunoExistenteOptional.isPresent()) {
            Aluno alunoExistente = alunoExistenteOptional.get();

            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setEmail(alunoAtualizado.getEmail());
            alunoExistente.setTelefone(alunoAtualizado.getTelefone());
            alunoExistente.setCpf(alunoAtualizado.getCpf());

            return alunoRepository.save(alunoExistente);
        } else {
            return null;
        }
    }

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}