package com.example.CocinandoConJava.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.CocinandoConJava.modelos.Dificultad;

@RepositoryRestResource(collectionResourceRel = "dificultades", path = "dificultades")
public interface DificultadRepository extends CrudRepository<Dificultad, Long> {

}
