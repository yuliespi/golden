package golden.golden.Models.Rol;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import golden.golden.Models.Empleado.Empleado;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreRol;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Empleado> empleado;

    public Roles() {
    }

    public Roles(Integer id, String nombreRol, List<Empleado> empleado) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.empleado = empleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}