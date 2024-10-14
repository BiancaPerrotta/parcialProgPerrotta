package com.example.parcialProgramacion.controllers;

import com.example.parcialProgramacion.domain.dto.DnaAllDto;
import com.example.parcialProgramacion.domain.dto.DnaShortDto;
import com.example.parcialProgramacion.domain.entities.DnaEntity;
import com.example.parcialProgramacion.services.DnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    private final DnaService dnaService;

    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }

    //listar todas las secuencias de ADN
    @GetMapping("/list")
    public ResponseEntity<List<DnaEntity>> getAllDna() {
        List<DnaEntity> dnaList = dnaService.getAllDna();
        return ResponseEntity.ok(dnaList);
    }

    //obtener todos los datos detallados de una secuencia especificada por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<DnaAllDto> getAllDataById(@PathVariable Long id) {
        DnaEntity dnaEntity = dnaService.findById(id);
        if (dnaEntity == null) {
            return ResponseEntity.notFound().build();
        }

        DnaAllDto data = dnaService.convertToAllDto(dnaEntity);
        return ResponseEntity.ok().body(data);
    }

    //obtener una version resumida de los datos de una secuencia especificada por ID
    @GetMapping("/short/{id}")
    public ResponseEntity<DnaShortDto> getShortDataById(@PathVariable Long id) {
        DnaEntity dnaEntity = dnaService.findById(id);
        if (dnaEntity == null) {
            return ResponseEntity.notFound().build();
        }

        DnaShortDto data = dnaService.convertToShortDto(dnaEntity);
        return ResponseEntity.ok().body(data);
    }

    //ruta para crear una nueva secuencia de ADN
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody DnaAllDto dnaAllDto) {
        try {

            DnaEntity createdEntity = dnaService.processAndSave(dnaAllDto);

            if (createdEntity == null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El ADN no pudo ser procesado");
            }


            DnaAllDto createdData = dnaService.convertToAllDto(createdEntity);


            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdData);

        } catch (IllegalArgumentException e) {
            // Capturar excepciones de validación
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            // Capturar cualquier otra excepción
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error inesperado: " + e.getMessage());
        }
    }

}