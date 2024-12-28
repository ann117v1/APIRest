package com.ForoHub.APIRest.controller;

import com.ForoHub.APIRest.dto.DatosActulizarTopico;
import com.ForoHub.APIRest.dto.DatosRegistroTopico;
import com.ForoHub.APIRest.dto.DatosRespuestaActualizar;
import com.ForoHub.APIRest.modelo.Topico;
import com.ForoHub.APIRest.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;



    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico con ID " + id + " no encontrado"));
        return ResponseEntity.ok(topico);
    }


    @PostMapping
    public ResponseEntity<DatosRespuestaActualizar> registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = new Topico();
        topico.setAutor(datosRegistroTopico.autor());
        topico.setCurso(datosRegistroTopico.curso());
        topico.setTitulo(datosRegistroTopico.titulo());
        topico.setMensaje(datosRegistroTopico.mensaje());

        topicoRepository.save(topico);
        System.out.println("Datos recibidos: " + datosRegistroTopico);

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        DatosRespuestaActualizar respuestaActualizar = new DatosRespuestaActualizar(topico);
        return ResponseEntity.created(url).body(respuestaActualizar);
    }



    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaActualizar> actualizarTopico(
            @PathVariable Long id,
            @RequestBody DatosActulizarTopico datosActulizarTopico) {

        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.actualizarDatos(datosActulizarTopico);
            Topico topicoActualizado = topicoRepository.save(topico);

            // Crear la respuesta basada en los datos del objeto actualizado
            DatosRespuestaActualizar respuesta = new DatosRespuestaActualizar(
                    topicoActualizado.getId(),
                    topicoActualizado.getAutor(),
                    topicoActualizado.getCurso(),
                    topicoActualizado.getTitulo(),
                    topicoActualizado.getMensaje()
            );

            return ResponseEntity.ok(respuesta);
        } else {
            throw new RuntimeException("Tópico con ID " + id + " no encontrado");
        }
    }


    //METODO PARA BORRAR COMPLETAMENTE EL TOPICO SEGUN ID
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Tópico con ID " + id + " no encontrado");
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
