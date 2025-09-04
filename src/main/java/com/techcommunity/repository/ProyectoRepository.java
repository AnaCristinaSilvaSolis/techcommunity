package com.techcommunity.repository;


import com.techcommunity.dto.ReporteActivosDTO;
import com.techcommunity.dto.ReporteCategoriaDTO;
import com.techcommunity.dto.ReporteDuracionDTO;
import com.techcommunity.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query(value = "CALL total_proyectos_por_categoria()", nativeQuery = true)
    List<ReporteCategoriaDTO> totalProyectosPorCategoria();

    @Query(value = "CALL duracion_promedio_proyectos()", nativeQuery = true)
    List<ReporteDuracionDTO> duracionPromedioProyectos();

    @Query(value = "CALL proyectos_activos()", nativeQuery = true)
    List<ReporteActivosDTO> proyectosActivos();
}
