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
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
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




   public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.createdAt = LocalDateTime.now();
        this.status = Status.NO_RESPONDIDO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void actualizarTopico(@Valid DatosActualizarTopico datos) {
        if(datos.titulo()!=null){
            this.titulo= datos.titulo();
        }if(datos.mensaje()!=null){
            this.mensaje= datos.mensaje();
        }if(datos.status()!=null){
            this.status= datos.status();
        }
        if(datos.curso()!=null){
            this.curso= datos.curso();
        }
    }
}
