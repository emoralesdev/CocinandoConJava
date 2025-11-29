package com.example.cocinandoconjava.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cocinandoconjava.modelos.Dificultad;
import com.example.cocinandoconjava.modelos.Receta;
import com.example.cocinandoconjava.servicios.AnonimoService;
import com.example.cocinandoconjava.utils.HtmlSanitizer;

import jakarta.validation.Valid;


@Controller
public class IndexController {
	
	@Autowired
	private AnonimoService anonimoService;
	
	@Value("${app.upload.dir}")
    private String uploadDir;
	

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
	public String registroReceta(@Valid @ModelAttribute Receta receta,BindingResult result,Model model,@RequestParam("file") MultipartFile file) throws IOException {
		
		if (result.hasErrors()) {
			List<Dificultad> dificultades = anonimoService.listadoDificultades();
	        model.addAttribute("dificultades", dificultades);
	        return "insertar"; 
	    }
		
		
		
		if (!file.isEmpty()) {
		    String fileName = file.getOriginalFilename();

		    Path directory = Paths.get(uploadDir);
		    Files.createDirectories(directory); 
		    System.out.println("Ruta carpeta: " + directory.toAbsolutePath());

		    Path filePath = directory.resolve(fileName);
		    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			
			receta.setImage(fileName);
		}
		
		String cleanHtml = HtmlSanitizer.clean(receta.getContenidoHtml());
		receta.setContenidoHtml(cleanHtml);
		
		anonimoService.guardar(receta);
		return "redirect:/insertar";
	}
	
}
