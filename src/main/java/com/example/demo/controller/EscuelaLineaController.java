package com.example.demo.controller;

import com.example.demo.Dto.EscuelaLineaDto;
import com.example.demo.service.EscuelaLineaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escuelas-lineas")
@CrossOrigin(origins = "http://localhost:4200/")
@PreAuthorize("hasRole('SECRETARIA')")
public class EscuelaLineaController {

    @Autowired
    private EscuelaLineaService escuelaLineaService;

    // Listar todas las escuelas con las líneas y sus IDs
    @GetMapping
    public ResponseEntity<List<EscuelaLineaDto>> getAllEscuelasLineas() {
        List<EscuelaLineaDto> escuelas = escuelaLineaService.getEscuelasLineasConNombres();
        return ResponseEntity.ok(escuelas);
    }

    // Obtener una escuela específica con carrera y líneas
    @GetMapping("/{id}")
    public ResponseEntity<EscuelaLineaDto> getEscuelaById(@PathVariable Long id) {
        EscuelaLineaDto escuela = escuelaLineaService.getEscuelaById(id);
        return ResponseEntity.ok(escuela);
    }

    // Otros métodos permanecen igual
}
