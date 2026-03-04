package Challenge.Foro.domain.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        String curso,
        Status status
) {
    public DatosActualizarTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getStatus()
        );
    }
}