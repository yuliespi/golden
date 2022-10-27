package goldenlions.golden.Models.Actividad;

import java.util.List;

import goldenlions.golden.Models.Bitacora.Bitacora;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(length=10)
    @Size(min = 5, max = 20)
    private String tipoActividad;

    
    private String fechaActividad;

    @NotEmpty
    @Column(length=10)
    @Size(min = 10, max = 50)
    private String descripcionActividad;
    
    // -------------Relacion con Bitacora----------------//
    @OneToMany(mappedBy = "Actividad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bitacora> Bitacora;


    
    public Actividad() {
    }


    
    public Actividad(Integer id, @NotEmpty String tipoActividad, String fechaActividad, String descripcionActividad,
            List<goldenlions.golden.Models.Bitacora.Bitacora> bitacora) {
        this.id = id;
        this.tipoActividad = tipoActividad;
        this.fechaActividad = fechaActividad;
        this.descripcionActividad = descripcionActividad;
        Bitacora = bitacora;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }

    public void setFechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public List<Bitacora> getBitacora() {
        return Bitacora;
    }

    public void setBitacora(List<Bitacora> bitacora) {
        Bitacora = bitacora;
    }

    
}
