package Challenge.Foro.domain;

public class Validacion extends RuntimeException {
    public Validacion(String mensaje) {
        super(mensaje);
    }
}
