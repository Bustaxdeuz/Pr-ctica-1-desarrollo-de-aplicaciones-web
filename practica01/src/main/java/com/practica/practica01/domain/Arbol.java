package com.practica.practica01.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;
    
    @Column(name = "nombre_comun", nullable = false, length = 100)
    private String nombreComun;
    
    @Column(name = "tipo_flor", length = 100)
    private String tipoFlor;
    
    @Column(name = "dureza_madera", length = 50)
    private String durezaMadera;
    
    @Column(name = "altura_maxima")
    private Double alturaMaxima;
    
    @Column(name = "ruta_imagen")
    private String rutaImagen;
}