package com.example.CocinandoConJava.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.CocinandoConJava.modelos.Dificultad;
import com.example.CocinandoConJava.modelos.Receta;
import com.example.CocinandoConJava.repositorios.DificultadRepository;
import com.example.CocinandoConJava.repositorios.RecetaRepository;


@Component
public class Pruebas implements CommandLineRunner {

	@Autowired
	private RecetaRepository recetasRepository;
	@Autowired
	private DificultadRepository dificultadRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		var easy = dificultadRepository.save(Dificultad.builder().dificultad("fácil").build());
		
		dificultadRepository.save(Dificultad.builder().dificultad("normal").build());
		dificultadRepository.save(Dificultad.builder().dificultad("difícil").build());
		
		dificultadRepository.findAll().forEach(System.out::println);
		
		recetasRepository.save(Receta.builder().nombre("Arepas").descripcion("..").image("..").dificultad(easy).build());
	}

}
