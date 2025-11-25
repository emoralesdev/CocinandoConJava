package com.example.cocinandoconjava.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.cocinandoconjava.modelos.Dificultad;
import com.example.cocinandoconjava.modelos.Receta;
import com.example.cocinandoconjava.repositorios.DificultadRepository;
import com.example.cocinandoconjava.repositorios.RecetaRepository;

@Component
public class Pruebas implements CommandLineRunner {

	@Autowired
	private RecetaRepository recetasRepository;

	@Autowired
	private DificultadRepository dificultadRepository;

	@Override
	public void run(String... args) throws Exception {

		var facil = dificultadRepository.save(Dificultad.builder().dificultad("fácil").build());
		var media = dificultadRepository.save(Dificultad.builder().dificultad("media").build());
		var dificil = dificultadRepository.save(Dificultad.builder().dificultad("difícil").build());

		dificultadRepository.findAll().forEach(System.out::println);

		recetasRepository.save(Receta.builder().nombre("Spaghetti Bolognesa").descripcion("...").dificultad(facil).build());
		recetasRepository.save(Receta.builder().nombre("Pollo al Curry").descripcion("...").dificultad(media).build());
		recetasRepository.save(Receta.builder().nombre("Soufflé de chocolate").descripcion("...").dificultad(dificil).build());
	}
}
