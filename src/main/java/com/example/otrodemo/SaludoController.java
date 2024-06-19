package com.example.otrodemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping(path = "/saludo")
    public String saludar() {
        return "Saludos desde Otro componente";
    }

    @GetMapping(path = "/otro")
    public String saludar2() {
        return "Soy el Mejor rolling update";
    }

    @GetMapping(path = "/nuevo")
    public String nuevo() {
        return "soy nuevo";
    }

    @GetMapping(path = "/nuevo2")
    public String nuevo2() {
        return "soy nuevo2";
    }
}
