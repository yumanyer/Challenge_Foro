package Challenge.Foro.domain.Topico;

import Challenge.Foro.domain.Topico.Status;
import Challenge.Foro.domain.Topico.Topico;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        Status status,
        LocalDateTime createdAt
) {
    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatus(),
                topico.getCreatedAt()
        );
    }
}