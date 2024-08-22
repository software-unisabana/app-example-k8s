package com.example.otrodemo;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SaludoController {

    @GetMapping(path = "/saludo")
    public String saludar() {
        return "Saludos con proceso CD";
    }

    @GetMapping(path = "/nuevo-saludo")
    public String saludar3() {
        return "Nuevo Slaudo desde la clase de arquitectura";
    }

    @GetMapping(path = "/despedirse")
    public String adios() {
        return "adios";
    }


    @GetMapping(path = "/otro")
    public String saludar2() {
        return "Soy el Mejor rolling update";
    }

    @GetMapping(path = "/consumo/{cantidad}")
    public String nuevo(@PathVariable int cantidad) {
        int OBJECT_SIZE = 1024 * 1024; // 1 MB por objeto
        List<byte[]> memoryConsumers = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            // Crear un nuevo objeto que consume memoria
            byte[] memoryChunk = new byte[OBJECT_SIZE];
            // Rellenar el objeto con datos para asegurarse de que se almacene en memoria
            for (int j = 0; j < memoryChunk.length; j++) {
                memoryChunk[j] = 1;
            }
            // Almacenar el objeto en la lista para que no sea recolectado por el GC
            memoryConsumers.add(memoryChunk);
            System.out.println("Allocated " + (i + 1) + " MB");
        }
        System.out.println("Finished allocating memory.");
        // Mantener la aplicación en ejecución
        try {
            Thread.sleep(1000); // Mantener la aplicación viva durante 60 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "soy nuevo";
    }

    @GetMapping(path = "/nuevo2")
    public String nuevo2() {
        return "soy nuevo2";
    }
}
