package com.ForoHub.APIRest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActulizarTopico(@NotNull Long id,
                                   @NotBlank
                                   String autor,
                                   String curso,
                                   @NotBlank
                                   String titulo,
                                   @NotBlank
                                   String mensaje) {


}
