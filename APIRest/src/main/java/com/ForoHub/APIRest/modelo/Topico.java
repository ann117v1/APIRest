package com.ForoHub.APIRest.modelo;

import com.ForoHub.APIRest.dto.DatosActulizarTopico;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String autor;
    String curso;
    String titulo;
    String mensaje;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public void actualizarDatos(DatosActulizarTopico datosActulizarTopico) {
        if (datosActulizarTopico.autor() != null) {
            this.autor = datosActulizarTopico.autor();
        }
        if (datosActulizarTopico.titulo() != null) {
            this.titulo = datosActulizarTopico.titulo();
        }
        if (datosActulizarTopico.mensaje() != null) {
            this.mensaje = datosActulizarTopico.mensaje();
        }

    }
}
