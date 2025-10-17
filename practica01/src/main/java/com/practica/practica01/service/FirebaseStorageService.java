package com.practica.practica01.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id) {
        if (archivoLocalCliente != null && !archivoLocalCliente.isEmpty()) {
            return "/images/" + carpeta + "/" + id + "_" + archivoLocalCliente.getOriginalFilename();
        }
        return null;
    }
}