package com.example.cocinandoconjava.servicios;

import java.util.List;
import java.util.Optional;

import com.example.cocinandoconjava.modelos.Dificultad;
import com.example.cocinandoconjava.modelos.Receta;


public interface AnonimoService {
	List<Receta>  listadoRecetas();
	List<Dificultad>  listadoDificultades();
	Receta guardar(Receta receta);
	Optional<Receta> obtenerReceta(Long recetaId);
}
