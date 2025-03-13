package com.mycompany.crud.hibernate.spring.controller;

import com.mycompany.crud.hibernate.spring.model.Recurso;
import com.mycompany.crud.hibernate.spring.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> getAllRecursos() {
        return recursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable Long id) {
        Optional<Recurso> recurso = recursoService.findById(id);
        return recurso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recurso> createRecurso(@RequestBody Recurso recurso) {
        Recurso savedRecurso = recursoService.save(recurso);
        return new ResponseEntity<>(savedRecurso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> updateRecurso(@PathVariable Long id, @RequestBody Recurso recurso) {
        Optional<Recurso> existingRecurso = recursoService.findById(id);
        if (existingRecurso.isPresent()) {
            recurso.setId(id);
            Recurso updatedRecurso = recursoService.save(recurso);
            return ResponseEntity.ok(updatedRecurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable Long id) {
        Optional<Recurso> existingRecurso = recursoService.findById(id);
        if (existingRecurso.isPresent()) {
            recursoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
