package com.mycompany.crud.hibernate.spring.repository;

import com.mycompany.crud.hibernate.spring.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
