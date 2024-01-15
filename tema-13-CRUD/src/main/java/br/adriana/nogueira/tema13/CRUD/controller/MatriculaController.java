package br.adriana.nogueira.tema13.CRUD.controller;

import br.adriana.nogueira.tema13.CRUD.model.Matricula;
import br.adriana.nogueira.tema13.CRUD.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @Autowired
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<Matricula> criarMatricula(@RequestBody Matricula matricula) {
        Matricula novaMatricula = matriculaService.criarMatricula(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMatricula);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas() {
        List<Matricula> matriculas = matriculaService.listarMatriculas();
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarMatriculaPorId(@PathVariable Long id) {
        Matricula matricula = matriculaService.buscarMatriculaPorId(id);
        if (matricula != null) {
            return ResponseEntity.ok(matricula);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
        matriculaService.deletarMatricula(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        Matricula matriculaAtualizada = matriculaService.atualizarMatricula(id, matricula);
        if (matriculaAtualizada != null) {
            return ResponseEntity.ok(matriculaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }
}
