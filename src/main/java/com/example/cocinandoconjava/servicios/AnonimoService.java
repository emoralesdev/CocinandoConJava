package com.example.cocinandoconjava.servicios;

import java.util.List;

import com.example.cocinandoconjava.modelos.Dificultad;
import com.example.cocinandoconjava.modelos.Receta;


public interface AnonimoService {
	List<Receta>  listadoRecetas();
	List<Dificultad>  listadoDificultades();
	Receta guardar(Receta receta);
}
