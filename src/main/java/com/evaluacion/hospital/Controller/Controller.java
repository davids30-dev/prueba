package com.evaluacion.hospital.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
//@RestController
public class Controller {


    @GetMapping("/")
    public String home(Model model) {
        // Datos que se enviarán a la vista
        model.addAttribute("title", "Bienvenido a mi sitio web");
        model.addAttribute("description", "Este es un ejemplo de Spring Boot con Thymeleaf.");
        return "home"; // Nombre del archivo HTML (home.html)
    }
    @GetMapping("/AltaDoctores")
    public String altaDoctores(Model model) {
        // Datos que se enviarán a la vista
        model.addAttribute("title", "Bienvenido a mi sitio web");
        model.addAttribute("description", "Este es un ejemplo de Spring Boot con Thymeleaf.");
        return "AltaDoctores"; // Nombre del archivo HTML (home.html)
    }
    @GetMapping("/altaConsultorios")
    public String altaConsultorios(Model model) {
        // Datos que se enviarán a la vista
        model.addAttribute("title", "Bienvenido a mi sitio web");
        model.addAttribute("description", "Este es un ejemplo de Spring Boot con Thymeleaf.");
        return "altaConsultorios"; // Nombre del archivo HTML (home.html)
    }
    @GetMapping("/altaCitas")
    public String altaCitas(Model model) {
        // Datos que se enviarán a la vista
        model.addAttribute("title", "Bienvenido a mi sitio web");
        model.addAttribute("description", "Este es un ejemplo de Spring Boot con Thymeleaf.");
        return "altaCitas"; // Nombre del archivo HTML (home.html)
    }


}
