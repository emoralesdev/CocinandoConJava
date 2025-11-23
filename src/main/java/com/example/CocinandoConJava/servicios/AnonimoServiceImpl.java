package com.example.CocinandoConJava.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CocinandoConJava.modelos.Dificultad;
import com.example.CocinandoConJava.modelos.Receta;
import com.example.CocinandoConJava.repositorios.DificultadRepository;
import com.example.CocinandoConJava.repositorios.RecetaRepository;

import lombok.extern.java.Log;

@Log
@Service
public class AnonimoServiceImpl implements AnonimoService {
	@Autowired
	private RecetaRepository recetasRepository;
	@Autowired
	private DificultadRepository dificultadRepository;
	
	@Override
	public List<Receta> listadoRecetas() {
		//log.info("Se han pedido los productos de la página " + pageable.getPageNumber() + " con tamaño " + pageable.getPageSize());
		return (List<Receta>) recetasRepository.findAll();
	}

	@Override
	public List<Dificultad> listadoDificultades() {
		// TODO Auto-generated method stub
		return (List<Dificultad>) dificultadRepository.findAll();
	}

	@Override
	public Receta guardar(Receta receta) {
		// TODO Auto-generated method stub
		return recetasRepository.save(receta);
	}

	

}
