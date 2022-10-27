package goldenlions.golden.Models.Empleado;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import goldenlions.golden.Models.Bitacora.Bitacora;
import goldenlions.golden.Models.Cargo.Cargo;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(length=10)
    @Size(min = 2, max = 10)
    private String nombreEmpleado;

    @NotEmpty
    @Column(length=10)
    @Size(min = 2, max = 10)
    private String apellidoEmpleado;

    @NotEmpty
    @Column(length=10)
    @Size(min = 5, max = 30)
    private String direccionEmpleado;

    
    @NotEmpty
    @Column(length=20)
    @Size(min = 15, max = 30)
    private String correoEmpleado;

    @NotEmpty
    @Column(length=10)
    @Size(min = 10, max = 20)
    private String contrasenaEmpleado;


    @NotEmpty
    @Column(length=10)
    @Size(min = 8, max = 10)
    private String telefonoEmpleado;

    @NotEmpty
    @Column(length=10)
    @Size(min = 5, max = 10)
    private String estadoEmpleado;

    // -------------Relacion con Bitacora----------------//
    @ManyToMany(mappedBy = "Empleado", fetch = FetchType.LAZY)
    private List<Bitacora> Bitacora;

    // -------------Relacion con Cargo----------------//
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo Cargo;

    public Empleado() {
    }

    public Empleado(Integer id, @NotEmpty String nombreEmpleado, String apellidoEmpleado, String direccionEmpleado, String correoEmpleado,
    String contrasenaEmpleado, String telefonoEmpleado, String estadoEmpleado, List<goldenlions.golden.Models.Bitacora.Bitacora> bitacora,
            goldenlions.golden.Models.Cargo.Cargo cargo) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.contrasenaEmpleado = contrasenaEmpleado;
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

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getContrasenaEmpleado() {
        return contrasenaEmpleado;
    }

    public void setContrasenaEmpleado(String contrasenaEmpleado) {
        this.contrasenaEmpleado = contrasenaEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
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

