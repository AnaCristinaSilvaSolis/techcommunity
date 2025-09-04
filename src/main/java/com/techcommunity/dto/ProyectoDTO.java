package com.techcommunity.dto;

import com.techcommunity.entity.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProyectoDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Estado estado;
}
