package com.example.CocinandoConJava.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public Page<Receta> listadoRecetas(Pageable pageable) {
		log.info("Se han pedido los productos de la página " + pageable.getPageNumber() + " con tamaño " + pageable.getPageSize());
		return recetasRepository.findAll(pageable);
	}

	

}
