package com.algoritmo.controller;

import com.algoritmo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

@RestController
public class UrlController {


    @Autowired
    private UrlService urlService;

    @GetMapping("/filtrar-urls")
    public Set<String> filtrarUrls(@RequestParam String rutaArchivo) throws IOException {
        return urlService.obtenerUrlsFiltradas(rutaArchivo);
    }

    @GetMapping("/contar-urls")
    public int contarUrls(@RequestParam String rutaArchivo) throws IOException {
        return urlService.contarUrlsFiltradas(rutaArchivo);
    }
}
