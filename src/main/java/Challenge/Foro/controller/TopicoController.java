package Challenge.Foro.controller;

import Challenge.Foro.domain.Topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")

public class TopicoController {



    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<Object> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new RuntimeException("Ya existe un tópico con el mismo título y mensaje");
        }
        Topico topico = new Topico(datos);
        topicoRepository.save(topico);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public ResponseEntity<Page<ListaTopicos>> listarTopicos(@PageableDefault(size = 10, sort = "createdAt") Pageable paginacion) {

        var page = topicoRepository.findAll(paginacion)
                .map(ListaTopicos::new);

        return ResponseEntity.ok(page);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallesTopico> detalles (@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return  ResponseEntity.ok(new DatosDetallesTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetallesTopico> actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {

        var optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var topico = optionalTopico.get();
        topico.actualizarTopico(datos);

        return ResponseEntity.ok(new DatosDetallesTopico(topico));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        var optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build(); // 204
    }

}
