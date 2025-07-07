package com.example.CifraFree.infra.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CifraFree.application.usuario.dtos.UsuarioDTO;
import com.example.CifraFree.infra.usuario.services.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> usuarios = usuarioService.getAllClientes();
        return ResponseEntity.ok(usuarios);
    }
    
}
