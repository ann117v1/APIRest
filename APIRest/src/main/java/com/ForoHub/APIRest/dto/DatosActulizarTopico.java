package com.ForoHub.APIRest.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActulizarTopico(@NotNull Long id, String autor, String curso, String titulo, String mensaje) {


}
