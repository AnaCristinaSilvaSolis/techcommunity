package com.techcommunity.controller;

import com.techcommunity.dto.ProyectoDTO;
import com.techcommunity.dto.ReporteActivosDTO;
import com.techcommunity.dto.ReporteCategoriaDTO;
import com.techcommunity.dto.ReporteDuracionDTO;
import com.techcommunity.services.IProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping("/proyectos")
    public ResponseEntity<List<ProyectoDTO>> findAll(){
        return ResponseEntity.ok(proyectoService.findAll());
    }

    @PostMapping("/proyectos")
    public ResponseEntity<ProyectoDTO> crearProyecto(@RequestBody ProyectoDTO proyectoDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(proyectoService.crearProyecto(proyectoDTO));
    }

    @GetMapping("/estadisticas/categorias")
    public ResponseEntity<List<ReporteCategoriaDTO>> obtenerTotalProyectosPorCategoria(){
        return ResponseEntity.ok(proyectoService.obtenerTotalProyectosPorCategoria());
    }

    @GetMapping("/estadisticas/duracion-promedio")
    public ResponseEntity<List<ReporteDuracionDTO>> obtenerDuracionPromedioProyectos(){
        return ResponseEntity.ok(proyectoService.obtenerDuracionPromedioProyectos());
    }

    @GetMapping("/estadisticas/activos")
    public ResponseEntity<List<ReporteActivosDTO>> obtenerProyectosActivos(){
        return ResponseEntity.ok(proyectoService.obtenerProyectosActivos());
    }
}
