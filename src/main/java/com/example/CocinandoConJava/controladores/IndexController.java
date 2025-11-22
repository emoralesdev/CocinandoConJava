package com.example.CocinandoConJava.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class IndexController {
	private static final int TAMANO_PAGINA = 2;

	

	@GetMapping
	public String index(Model modelo, @RequestParam(name = "id", required = false) Long idCategoria,
			@RequestParam(name = "pagina", required = false, defaultValue = "0") int numeroPagina) {
		
		return "index";
	}

	
}
