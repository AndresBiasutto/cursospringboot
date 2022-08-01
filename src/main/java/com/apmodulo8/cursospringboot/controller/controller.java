/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apmodulo8.cursospringboot.controller;

import java.util.ArrayList;
import java.util.List;
import model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
public class controller {
    
    List<Persona> listaDePersonas= new ArrayList();
    
    //devuelve el contenido de la funcion al recibir una solicitud
    @GetMapping ("/hola/{nombre}")
    public String decirHola(@PathVariable String nombre,
                            @PathVariable String apellido,
                            @PathVariable int edad){
        return "hola don " + nombre + " " + apellido + ", señor inutil de " + edad + " años! como le va!";
    }
    
    @GetMapping ("/chau")
    public String decirChau (@RequestParam String nombre,
                             @RequestParam String apellido,
                             @RequestParam int edad){
        return "nos vemos " + nombre + " " + apellido + " " + ", veo que ya tenes " + edad + ", sos un viejo inutil";
    }
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers){
        listaDePersonas.add(pers);
    }
    
    @GetMapping ("ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return listaDePersonas;
    }
    
    
}
