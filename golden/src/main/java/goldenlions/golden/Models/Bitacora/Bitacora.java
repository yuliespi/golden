package goldenlions.golden.Models.Bitacora;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import goldenlions.golden.Models.Implemento.Implemento;
import goldenlions.golden.Models.Actividad.Actividad;
import goldenlions.golden.Models.Empleado.Empleado;

@Entity
@Table(name="bitacora")
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

      @NotEmpty
    @Column(length=10)
    @Size(min = 5, max = 15)
    private String observacionesBitacora;

    @NotEmpty
    @Column(length=10)
    @Size(min = 1, max = 2)
    private String cantidadImplementosUsados;

    
    private String fechaBitacora;

    @NotEmpty
    @Column(length=10)
    @Size(min = 5, max = 10)
    private String estadoBitacora;

// -------------Relacion con Implemento----------------//
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
    name = "bitacora_implemento",
    joinColumns = @JoinColumn(name = "id_bitacora"),
    inverseJoinColumns = @JoinColumn(name="id_implemento")
)
private List<Implemento> Implemento;

// -------------Relacion con Empleado----------------//
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
    name = "bitacora_empleado",
    joinColumns = @JoinColumn(name = "id_bitacora"),
    inverseJoinColumns = @JoinColumn(name="id_empleado")
)
private List<Empleado> Empleado;

    // -------------Relacion con Actividad----------------//
    @ManyToOne(fetch = FetchType.LAZY)
    private Actividad Actividad;



    
    public Bitacora() {
    }


    
    public Bitacora(Integer id, @NotEmpty String observacionesBitacora, String cantidadImplementosUsados,
            String fechaBitacora, String estadoBitacora,
            List<goldenlions.golden.Models.Implemento.Implemento> implemento,
            List<goldenlions.golden.Models.Empleado.Empleado> empleado,
            goldenlions.golden.Models.Actividad.Actividad actividad) {
        this.id = id;
        this.observacionesBitacora = observacionesBitacora;
        this.cantidadImplementosUsados = cantidadImplementosUsados;
        this.fechaBitacora = fechaBitacora;
        this.estadoBitacora = estadoBitacora;
        Implemento = implemento;
        Empleado = empleado;
        Actividad = actividad;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacionesBitacora() {
        return observacionesBitacora;
    }

    public void setObservacionesBitacora(String observacionesBitacora) {
        this.observacionesBitacora = observacionesBitacora;
    }

    public String getCantidadImplementosUsados() {
        return cantidadImplementosUsados;
    }

    public void setCantidadImplementosUsados(String cantidadImplementosUsados) {
        this.cantidadImplementosUsados = cantidadImplementosUsados;
    }

    public String getFechaBitacora() {
        return fechaBitacora;
    }

    public void setFechaBitacora(String fechaBitacora) {
        this.fechaBitacora = fechaBitacora;
    }

    public String getEstadoBitacora() {
        return estadoBitacora;
    }

    public void setEstadoBitacora(String estadoBitacora) {
        this.estadoBitacora = estadoBitacora;
    }

    public List<Implemento> getImplemento() {
        return Implemento;
    }

    public void setImplemento(List<Implemento> implemento) {
        Implemento = implemento;
    }

    public List<Empleado> getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        Empleado = empleado;
    }

    public Actividad getActividad() {
        return Actividad;
    }

    public void setActividad(Actividad actividad) {
        Actividad = actividad;
    }

    
}
