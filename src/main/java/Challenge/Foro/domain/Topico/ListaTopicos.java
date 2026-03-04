package Challenge.Foro.domain.Topico;

public record ListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso) {
    public ListaTopicos(Topico topico ) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso());
    }
}
