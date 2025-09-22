package com.example.CifraFree.infra.cifra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.infra.cifra.services.CifraService;

@RestController
@RequestMapping("/cifras")
public class CifraController {

    @Autowired
    private CifraService cifraService;

    @GetMapping("/list")
    public ResponseEntity<List<CifraDTO>> getAll() {
        List<CifraDTO> cifras = cifraService.getAllCifras();
        return ResponseEntity.ok(cifras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CifraDTO> getById(@PathVariable Long id) {
        try {
        CifraDTO cifra = cifraService.getCifraById(id);
        return ResponseEntity.ok(cifra);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CifraDTO> create(@RequestBody CifraDTO cifraDTO) {
        CifraDTO createdCifra = cifraService.createCifra(cifraDTO);
        return new ResponseEntity<>(createdCifra, HttpStatus.CREATED);
    }
}
