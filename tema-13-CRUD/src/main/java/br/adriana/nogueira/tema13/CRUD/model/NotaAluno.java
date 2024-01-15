package br.adriana.nogueira.tema13.CRUD.model;

import jakarta.persistence.*;
@Entity
public class NotaAluno {

    @EmbeddedId
    private NotaAlunoId id;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @MapsId("disciplinaId")
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @Column(name = "nota")
    private Double nota;

    public NotaAluno(Aluno aluno, Double nota) {
        this.aluno = aluno;
        this.nota = nota;
    }
}