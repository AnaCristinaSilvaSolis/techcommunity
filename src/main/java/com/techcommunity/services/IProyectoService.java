package com.techcommunity.services;

import com.techcommunity.dto.ProyectoDTO;
import com.techcommunity.dto.ReporteActivosDTO;
import com.techcommunity.dto.ReporteCategoriaDTO;
import com.techcommunity.dto.ReporteDuracionDTO;

import java.util.List;

public interface IProyectoService {

    List<ProyectoDTO> findAll();
    ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO);

    List<ReporteCategoriaDTO> obtenerTotalProyectosPorCategoria();
    List<ReporteDuracionDTO> obtenerDuracionPromedioProyectos();
    List<ReporteActivosDTO> obtenerProyectosActivos();

}
