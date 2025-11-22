package com.example.CocinandoConJava.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.CocinandoConJava.modelos.Dificultad;
import com.example.CocinandoConJava.modelos.Receta;


public interface AnonimoService {
	Page<Receta> listadoRecetas(Pageable pageable);
	//Page<Receta> listadoRecetas(Pageable pageable, Long idDificultad);
	//Receta detalleReceta(Long id);
	
	//Page<Dificultad> listadoDificultades(Pageable pageable);
	//Dificultad detalleDificultad(Long idDificultad);
	
	//Usuario registrarse(Usuario usuario);
}
