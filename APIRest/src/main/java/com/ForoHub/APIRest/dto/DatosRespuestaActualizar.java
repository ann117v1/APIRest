package com.ForoHub.APIRest.dto;

import com.ForoHub.APIRest.modelo.Topico;

public record DatosRespuestaActualizar(Long id, String autor, String curso, String titulo, String mensaje) {
    public DatosRespuestaActualizar (Topico topico){
        this(topico.getId(), topico.getAutor(), topico.getCurso(), topico.getTitulo(), topico.getMensaje());
    }
}
