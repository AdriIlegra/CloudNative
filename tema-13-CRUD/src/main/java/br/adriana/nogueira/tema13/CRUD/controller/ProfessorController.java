package br.adriana.nogueira.tema13.CRUD.controller;
import br.adriana.nogueira.tema13.CRUD.model.Professor;
import br.adriana.nogueira.tema13.CRUD.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> professores = professorService.listarProfessores();
        return ResponseEntity.ok(professores);
    }

    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.criarProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Professor professorAtualizado = professorService.atualizarProfessor(id, professor);
        if (professorAtualizado != null) {
            return ResponseEntity.ok(professorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        boolean deletado = professorService.deletarProfessor(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
