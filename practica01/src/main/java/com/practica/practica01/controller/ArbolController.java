package com.practica.practica01.controller;

import com.practica.practica01.domain.Arbol;
import com.practica.practica01.service.ArbolService;
import com.practica.practica01.service.FirebaseStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/arbol")
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var arboles = arbolService.getArboles();
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }
    
    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/nuevo";
    }
    
    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
                              @RequestParam("imagenFile") MultipartFile imagenFile) {
        arbolService.save(arbol);
        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                firebaseStorageService.cargaImagen(
                    imagenFile, "arbol", arbol.getIdArbol()));
        }
        arbolService.save(arbol);
        
        return "redirect:/arbol/listado";
    }
    
    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/editar";
    }
}