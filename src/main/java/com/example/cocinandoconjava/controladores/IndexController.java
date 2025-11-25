package com.example.cocinandoconjava.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cocinandoconjava.modelos.Dificultad;
import com.example.cocinandoconjava.modelos.Receta;
import com.example.cocinandoconjava.servicios.AnonimoService;

import jakarta.validation.Valid;


@Controller
public class IndexController {
	
	@Autowired
	private AnonimoService anonimoService;
	

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("mostrar")
	public String detalle(Model modelo) {
		
        List<Receta> recetas = anonimoService.listadoRecetas();
        modelo.addAttribute("recetas", recetas);

		return "mostrar";
	}
	
	@GetMapping("insertar")
	public String registro(Model model) {
		
		 model.addAttribute("receta", new Receta());
		 List<Dificultad> dificultades = anonimoService.listadoDificultades();
		 model.addAttribute("dificultades", dificultades);
		return "insertar";
	}
	
	@PostMapping("registro")
	public String registroReceta(@Valid @ModelAttribute Receta receta,BindingResult result,Model model) {
		
		if (result.hasErrors()) {
			List<Dificultad> dificultades = anonimoService.listadoDificultades();
	        model.addAttribute("dificultades", dificultades);
	        return "insertar"; 
	    }

		anonimoService.guardar(receta);
		return "redirect:/insertar";
	}
	
}
