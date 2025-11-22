package com.example.CocinandoConJava.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.CocinandoConJava.modelos.Receta;


@RepositoryRestResource(collectionResourceRel = "recetas", path = "recetas")
public interface RecetaRepository extends CrudRepository<Receta, Long>, PagingAndSortingRepository<Receta, Long> {

}
