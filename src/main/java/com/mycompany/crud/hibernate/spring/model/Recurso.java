package com.mycompany.crud.hibernate.spring.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuarioManyToOne;

    @ManyToMany(mappedBy = "recursosManyToMany")
    private Set<Usuario> usuariosManyToMany;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioManyToOne() {
        return usuarioManyToOne;
    }

    public void setUsuarioManyToOne(Usuario usuarioManyToOne) {
        this.usuarioManyToOne = usuarioManyToOne;
    }

    public Set<Usuario> getUsuariosManyToMany() {
        return usuariosManyToMany;
    }

    public void setUsuariosManyToMany(Set<Usuario> usuariosManyToMany) {
        this.usuariosManyToMany = usuariosManyToMany;
    }
}
