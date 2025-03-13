package com.mycompany.crud.hibernate.spring.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "usuario")
    private Recurso recurso;

    @OneToMany(mappedBy = "usuario")
    private Set<Recurso> recursos;

    @ManyToMany
    @JoinTable(
        name = "usuario_recurso",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "recurso_id")
    )
    private Set<Recurso> recursosManyToMany;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Set<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(Set<Recurso> recursos) {
        this.recursos = recursos;
    }

    public Set<Recurso> getRecursosManyToMany() {
        return recursosManyToMany;
    }

    public void setRecursosManyToMany(Set<Recurso> recursosManyToMany) {
        this.recursosManyToMany = recursosManyToMany;
    }
}
