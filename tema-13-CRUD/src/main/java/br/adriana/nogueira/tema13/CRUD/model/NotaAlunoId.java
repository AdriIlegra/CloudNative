package br.adriana.nogueira.tema13.CRUD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NotaAlunoId implements Serializable {

    @Column(name = "id_aluno")
    private Long alunoId;

    @Column(name = "id_disciplina")
    private Long disciplinaId;

    public NotaAlunoId() {
    }

    public NotaAlunoId(Long alunoId, Long disciplinaId) {
        this.alunoId = alunoId;
        this.disciplinaId = disciplinaId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
