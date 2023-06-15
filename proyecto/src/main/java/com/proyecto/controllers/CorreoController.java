package com.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/correo")
public class CorreoController {
    @GetMapping
    public String getCorreo(){
        return "Correo";
    }
}