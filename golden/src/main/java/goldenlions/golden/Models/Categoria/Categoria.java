package goldenlions.golden.Models.Categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

import goldenlions.golden.Models.Implemento.Implemento;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(length=11)
    @Size(min = 2, max = 3)
    private String edadCategoria;

    @NotEmpty
    @Column(length=11)
    @Size(min = 1, max = 3)
    private String cantidadPersonas;

    @NotEmpty
    @Column(length=10)
    @Size(min = 10, max = 50)
    private String descripcionCategoria;

    @NotEmpty
    @Column(length=10)
    @Size(min = 5, max = 10)
    private String estadoCategoria;

// -------------Relacion con Bitacora----------------//
@ManyToMany(mappedBy = "Categoria", fetch = FetchType.LAZY)
private List<Implemento> Implemento;

public Categoria() {
}




public Integer getId() {
    return id;
}
public Categoria(Integer id, @NotEmpty String edadCategoria, String cantidadPersonas, String descripcionCategoria,
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

public String getCantidadPersonas() {
    return cantidadPersonas;
}

public void setCantidadPersonas(String cantidadPersonas) {
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
