package com.example.cocinandoconjava.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cocinandoconjava.modelos.Dificultad;
import com.example.cocinandoconjava.modelos.Receta;
import com.example.cocinandoconjava.repositorios.DificultadRepository;
import com.example.cocinandoconjava.repositorios.RecetaRepository;

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
		return recetasRepository.findAll();
	}

	@Override
	public List<Dificultad> listadoDificultades() {
		return dificultadRepository.findAll();
	}

	@Override
	public Receta guardar(Receta receta) {
		return recetasRepository.save(receta);
	}

	@Override
	public Optional<Receta> obtenerReceta(Long recetaId) {
		// TODO Auto-generated method stub
		return recetasRepository.findById(recetaId);
	}
	
	

}
