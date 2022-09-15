package goldenlions.golden.Models.Empleado;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import goldenlions.golden.Models.Bitacora.Bitacora;
import goldenlions.golden.Models.Cargo.Cargo;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name ="nombreEmpleado", length=50)
    private String nombreEmpleado;

    @Column(name ="apellidoEmpleado", length=50)
    private String apellidoEmpleado;

    @Column(name ="direccionEmpleado", length=80)
    private String direccionEmpleado;

    @Column(name ="telefonoEmpleado", length=10)
    private Integer telefonoEmpleado;

    @Column(name ="estadoEmpleado", length=10)
    private String estadoEmpleado;

    // -------------Relacion con Bitacora----------------//
    @ManyToMany(mappedBy = "Empleado", fetch = FetchType.LAZY)
    private List<Bitacora> Bitacora;

    // -------------Relacion con Cargo----------------//
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo Cargo;

    public Empleado() {
    }

    public Empleado(Integer id, @NotEmpty String nombreEmpleado, String apellidoEmpleado, String direccionEmpleado,
            Integer telefonoEmpleado, String estadoEmpleado, List<goldenlions.golden.Models.Bitacora.Bitacora> bitacora,
            goldenlions.golden.Models.Cargo.Cargo cargo) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        Bitacora = bitacora;
        Cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public Integer getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(Integer telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public List<Bitacora> getBitacora() {
        return Bitacora;
    }

    public void setBitacora(List<Bitacora> bitacora) {
        Bitacora = bitacora;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo cargo) {
        Cargo = cargo;
    }

    
}

