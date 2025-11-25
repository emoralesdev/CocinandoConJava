package com.example.cocinandoconjava.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cocinandoconjava.modelos.Dificultad;

@RepositoryRestResource(collectionResourceRel = "dificultades", path = "dificultades")
public interface DificultadRepository extends JpaRepository<Dificultad, Long> {

}
