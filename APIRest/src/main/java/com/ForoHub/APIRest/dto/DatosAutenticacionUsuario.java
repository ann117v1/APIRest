package com.ForoHub.APIRest.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(@NotBlank String login,@NotBlank String clave) {
}
