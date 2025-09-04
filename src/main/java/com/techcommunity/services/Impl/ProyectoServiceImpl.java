package com.techcommunity.services.Impl;

import com.techcommunity.dto.ProyectoDTO;
import com.techcommunity.dto.ReporteActivosDTO;
import com.techcommunity.dto.ReporteCategoriaDTO;
import com.techcommunity.dto.ReporteDuracionDTO;
import com.techcommunity.entity.Proyecto;
import com.techcommunity.repository.ProyectoRepository;
import com.techcommunity.services.IProyectoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements IProyectoService {

    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProyectoDTO> findAll() {
        return proyectoRepository.findAll().stream()
                .map(proyecto -> modelMapper.map(proyecto, ProyectoDTO.class))
                .toList();
    }

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = modelMapper.map(proyectoDTO, Proyecto.class);
        Proyecto guardarProyecto = proyectoRepository.save(proyecto);

        return modelMapper.map(guardarProyecto, ProyectoDTO.class);
    }

    @Override
    public List<ReporteCategoriaDTO> obtenerTotalProyectosPorCategoria() {
        return proyectoRepository.totalProyectosPorCategoria();
    }

    @Override
    public List<ReporteDuracionDTO> obtenerDuracionPromedioProyectos() {
        return proyectoRepository.duracionPromedioProyectos();
    }

    @Override
    public List<ReporteActivosDTO> obtenerProyectosActivos() {
        return proyectoRepository.proyectosActivos();
    }

}
