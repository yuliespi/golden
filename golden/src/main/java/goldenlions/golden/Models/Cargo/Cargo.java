package goldenlions.golden.Models.Cargo;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import goldenlions.golden.Models.Empleado.Empleado;

@Entity
@Table(name="cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name ="nombreCargo", length=50)
    private String nombreCargo;

    @Column(name ="descripcionCargo", length=50)
    private String descripcionCargo;

    @Column(name ="estadoCargo", length=10)
    private String estadoCargo;

    // -------------Relacion con Empleado----------------//
    @OneToMany(mappedBy = "Cargo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Empleado> Empleado;

    public Cargo() {
    }

    public Cargo(Integer id, @NotEmpty String nombreCargo, String descripcionCargo, String estadoCargo,
            List<goldenlions.golden.Models.Empleado.Empleado> empleado) {
        this.id = id;
        this.nombreCargo = nombreCargo;
        this.descripcionCargo = descripcionCargo;
        this.estadoCargo = estadoCargo;
        Empleado = empleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    public String getEstadoCargo() {
        return estadoCargo;
    }

    public void setEstadoCargo(String estadoCargo) {
        this.estadoCargo = estadoCargo;
    }

    public List<Empleado> getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        Empleado = empleado;
    }



}

