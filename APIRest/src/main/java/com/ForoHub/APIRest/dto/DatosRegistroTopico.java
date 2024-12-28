package com.ForoHub.APIRest.dto;

import jakarta.validation.constraints.NotBlank;


public record DatosRegistroTopico(
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje)
       {
}
