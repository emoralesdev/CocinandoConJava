package com.example.cocinandoconjava.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cocinandoconjava.modelos.Receta;


@RepositoryRestResource(collectionResourceRel = "recetas", path = "recetas")
public interface RecetaRepository extends JpaRepository<Receta, Long>{

}
