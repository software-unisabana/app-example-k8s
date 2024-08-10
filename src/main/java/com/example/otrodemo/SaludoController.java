package com.example.otrodemo;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SaludoController {


    @GetMapping(path = "/saludo")
    public String saludar() {
        int OBJECT_SIZE = 1024 * 1024; // 1 MB por objeto
        int NUMBER_OF_OBJECTS = 1024; // 1024 MB (1 GB) en total
        List<byte[]> memoryConsumers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_OBJECTS; i++) {
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
            Thread.sleep(60000); // Mantener la aplicación viva durante 60 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
