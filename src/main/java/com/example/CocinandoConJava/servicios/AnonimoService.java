package com.example.CocinandoConJava.servicios;



import java.util.List;

import com.example.CocinandoConJava.modelos.Dificultad;
import com.example.CocinandoConJava.modelos.Receta;



public interface AnonimoService {
	List<Receta>  listadoRecetas();
	List<Dificultad>  listadoDificultades();
	Receta guardar(Receta receta);
	
}
