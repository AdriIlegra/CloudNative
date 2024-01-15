package br.adriana.nogueira.tema13.CRUD.controller;

import br.adriana.nogueira.tema13.CRUD.model.Curso;
import br.adriana.nogueira.tema13.CRUD.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import br.adriana.nogueira.tema13.CRUD.model.Curso;
import br.adriana.nogueira.tema13.CRUD.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso) {
        Curso cursoCriado = cursoService.criarCurso(curso);
        return ResponseEntity.status(201).body(cursoCriado);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        Curso cursoAtualizado = cursoService.atualizarCurso(id, curso);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }
}