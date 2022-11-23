package golden.golden.Models.Empleado;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import golden.golden.Models.Bitacora.Bitacora;
import golden.golden.Models.Cargo.Cargo;
import golden.golden.Models.Rol.Roles;

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

    @NotEmpty
    @Column(length=50)
    private String correoEmpleado;

    @NotEmpty
    @Column(length=300)
    private String contrasenaEmpleado;

    @Column(name ="estadoEmpleado")
    private Boolean estadoEmpleado=true;

    // -------------Relacion con Bitacora----------------//
    @ManyToMany(mappedBy = "Empleado", fetch = FetchType.LAZY)
    private List<Bitacora> Bitacora;

    // -------------Relacion con Cargo----------------//
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo Cargo;

    // -------------Relacion con Rol----------------//
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "empleados_roles",
        joinColumns = @JoinColumn(name = "empleado_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Roles> roles;

    public Empleado() {
    }

    public Empleado(Integer id, @NotEmpty String nombreEmpleado, String apellidoEmpleado, String direccionEmpleado,
            Integer telefonoEmpleado, @NotEmpty String correoEmpleado, @NotEmpty String contrasenaEmpleado,
            Boolean estadoEmpleado, List<golden.golden.Models.Bitacora.Bitacora> bitacora,
            golden.golden.Models.Cargo.Cargo cargo, List<Roles> roles) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.contrasenaEmpleado = contrasenaEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        Bitacora = bitacora;
        Cargo = cargo;
        this.roles = roles;
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

    public Boolean getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(Boolean estadoEmpleado) {
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}