package com.mycompany.crud.hibernate.spring.repository;

import com.mycompany.crud.hibernate.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
