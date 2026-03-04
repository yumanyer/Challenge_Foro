package Challenge.Foro.domain.Topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        Long id, @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotBlank String curso
) {

}
