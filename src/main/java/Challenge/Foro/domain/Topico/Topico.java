package Challenge.Foro.domain.Topico;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "topicos")
@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    
    @Column(columnDefinition = "TEXT")
    private String mensaje;
    
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;
    
    private String autor;
    
    private String curso;


    //CONSTRUCTOR obligatorio apra JPA
    public Topico() {};

   public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.createdAt = LocalDateTime.now();
        this.status = Status.NO_RESPONDIDO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }
}
