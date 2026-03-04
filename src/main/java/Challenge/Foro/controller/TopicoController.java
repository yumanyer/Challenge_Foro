package Challenge.Foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Challenge.Foro.domain.Topico.DatosRegistroTopico;
import Challenge.Foro.domain.Topico.Topico;
import Challenge.Foro.domain.Topico.TopicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoService;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        if (topicoService.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new RuntimeException("Ya existe un tópico con el mismo título y mensaje");
        }
        Topico topico = new Topico(datos);
        topicoService.save(topico); 

    }
}
