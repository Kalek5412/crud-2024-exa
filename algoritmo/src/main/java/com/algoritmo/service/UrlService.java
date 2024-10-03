package com.algoritmo.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class UrlService {
    public Set<String> obtenerUrlsFiltradas(String rutaArchivo) throws IOException {
        Set<String> urls = new HashSet<>(); // Usar un HashSet para eliminar duplicados(lis usa duplicados)

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String url = linea.trim();
                // Verificar que la URL contenga "shop" y termine en ".html"
                if (url.contains("shop") && url.endsWith(".html")) {
                    urls.add(url); // Agregar al Set, eliminando duplicados automáticamente
                }
            }
        }

        return urls; // Retornar las URLs filtradas
    }

    public int contarUrlsFiltradas(String rutaArchivo) throws IOException {
        return obtenerUrlsFiltradas(rutaArchivo).size(); // Retornar el número de URLs válidas
    }
}
