package br.adriana.nogueira.tema13.CRUD.controller;

import br.adriana.nogueira.tema13.CRUD.model.Disciplina;
import br.adriana.nogueira.tema13.CRUD.model.NotaAluno;
import br.adriana.nogueira.tema13.CRUD.service.DisciplinaService;
import br.adriana.nogueira.tema13.CRUD.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private DisciplinaService disciplinaService;
    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();
        return ResponseEntity.ok(disciplinas);
    }

    @PostMapping
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = disciplinaService.criarDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {
        Disciplina disciplina = disciplinaService.buscarDisciplinaPorId(id);
        if (disciplina != null) {
            return ResponseEntity.ok(disciplina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAtualizada = disciplinaService.atualizarDisciplina(id, disciplina);
        if (disciplinaAtualizada != null) {
            return ResponseEntity.ok(disciplinaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/notas-por-disciplina")
    public ResponseEntity<Map<Disciplina, List<NotaAluno>>> listarNotasPorDisciplina() {
        Map<Disciplina, List<NotaAluno>> notasPorDisciplina = matriculaService.listarNotasPorDisciplina();
        return ResponseEntity.ok(notasPorDisciplina);
    }
}
