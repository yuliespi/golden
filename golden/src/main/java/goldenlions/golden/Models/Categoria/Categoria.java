package goldenlions.golden.Models.Categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

import goldenlions.golden.Models.Implemento.Implemento;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name ="edadCategoria", length=10)
    private String edadCategoria;

    @Column(name ="cantidadPersonas", length=10)
    private Integer cantidadPersonas;

    @Column(name ="descripcionCategoria", length=50)
    private String descripcionCategoria;

    @Column(name ="estadoCategoria", length=10)
    private String estadoCategoria;

// -------------Relacion con Bitacora----------------//
@ManyToMany(mappedBy = "Categoria", fetch = FetchType.LAZY)
private List<Implemento> Implemento;

public Categoria() {
}




public Integer getId() {
    return id;
}
public Categoria(Integer id, @NotEmpty String edadCategoria, Integer cantidadPersonas, String descripcionCategoria,
        String estadoCategoria, List<goldenlions.golden.Models.Implemento.Implemento> implemento) {
    this.id = id;
    this.edadCategoria = edadCategoria;
    this.cantidadPersonas = cantidadPersonas;
    this.descripcionCategoria = descripcionCategoria;
    this.estadoCategoria = estadoCategoria;
    Implemento = implemento;
}




public void setId(Integer id) {
    this.id = id;
}

public String getEdadCategoria() {
    return edadCategoria;
}

public void setEdadCategoria(String edadCategoria) {
    this.edadCategoria = edadCategoria;
}

public Integer getCantidadPersonas() {
    return cantidadPersonas;
}

public void setCantidadPersonas(Integer cantidadPersonas) {
    this.cantidadPersonas = cantidadPersonas;
}

public String getDescripcionCategoria() {
    return descripcionCategoria;
}

public void setDescripcionCategoria(String descripcionCategoria) {
    this.descripcionCategoria = descripcionCategoria;
}

public String getEstadoCategoria() {
    return estadoCategoria;
}

public void setEstadoCategoria(String estadoCategoria) {
    this.estadoCategoria = estadoCategoria;
}

public List<Implemento> getImplemento() {
    return Implemento;
}

public void setImplemento(List<Implemento> implemento) {
    Implemento = implemento;
}


}
