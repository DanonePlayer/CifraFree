package com.example.CifraFree.infra.cifra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<CifraDTO> cifras = cifraService.getAllCifrasUseCase().execute();
        return ResponseEntity.ok(cifras);
    }
}
