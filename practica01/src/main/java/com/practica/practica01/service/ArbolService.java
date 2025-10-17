package com.practica.practica01.service;

import com.practica.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    List<Arbol> getArboles();
    
    Arbol getArbol(Arbol arbol);
    
    void save(Arbol arbol);
    
    void delete(Arbol arbol);
}