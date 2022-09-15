package goldenlions.golden.Models.Implemento;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import goldenlions.golden.Models.Bitacora.Bitacora;
import goldenlions.golden.Models.Categoria.Categoria;

@Entity
@Table(name="implemento")
public class Implemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name ="tipoImplemento", length=50)
    private String tipoImplemento;

    @Column(name ="nombreImplemento", length=50)
    private String nombreImplemento;

    @Column(name ="tamanoImplemento", length=11)
    private Integer tamanoImplemento;

    @Column(name ="pesoImplemento", length=50)
    private String pesoImplemento;

    @Column(name ="catidadImplemento", length=11)
    private Integer cantidadImplemento;

    @Column(name ="funcionImplemento", length=80)
    private String funcionImplemento;

    @Column(name ="observacionesImplemento", length=100)
    private String observacionesImplemento;

    @Column(name ="estadoImplemento", length=50)
    private String estadoImplemento;

// -------------Relacion con Bitacora----------------//
    @ManyToMany(mappedBy = "Implemento", fetch = FetchType.LAZY)
    private List<Bitacora> Bitacora;

// -------------Relacion con categoria----------------//
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
    name = "implemento_categoria",
    joinColumns = @JoinColumn(name = "id_implemento"),
    inverseJoinColumns = @JoinColumn(name="id_categoria")
)
private List<Categoria> Categoria;

public Implemento() {
}

public Implemento(Integer id, @NotEmpty String tipoImplemento, String nombreImplemento, Integer tamanoImplemento,
        String pesoImplemento, Integer cantidadImplemento, String funcionImplemento, String observacionesImplemento,
        String estadoImplemento, List<goldenlions.golden.Models.Bitacora.Bitacora> bitacora,
        List<goldenlions.golden.Models.Categoria.Categoria> categoria) {
    this.id = id;
    this.tipoImplemento = tipoImplemento;
    this.nombreImplemento = nombreImplemento;
    this.tamanoImplemento = tamanoImplemento;
    this.pesoImplemento = pesoImplemento;
    this.cantidadImplemento = cantidadImplemento;
    this.funcionImplemento = funcionImplemento;
    this.observacionesImplemento = observacionesImplemento;
    this.estadoImplemento = estadoImplemento;
    Bitacora = bitacora;
    Categoria = categoria;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getTipoImplemento() {
    return tipoImplemento;
}

public void setTipoImplemento(String tipoImplemento) {
    this.tipoImplemento = tipoImplemento;
}

public String getNombreImplemento() {
    return nombreImplemento;
}

public void setNombreImplemento(String nombreImplemento) {
    this.nombreImplemento = nombreImplemento;
}

public Integer getTamanoImplemento() {
    return tamanoImplemento;
}

public void setTamanoImplemento(Integer tamanoImplemento) {
    this.tamanoImplemento = tamanoImplemento;
}

public String getPesoImplemento() {
    return pesoImplemento;
}

public void setPesoImplemento(String pesoImplemento) {
    this.pesoImplemento = pesoImplemento;
}

public Integer getCantidadImplemento() {
    return cantidadImplemento;
}

public void setCantidadImplemento(Integer cantidadImplemento) {
    this.cantidadImplemento = cantidadImplemento;
}

public String getFuncionImplemento() {
    return funcionImplemento;
}

public void setFuncionImplemento(String funcionImplemento) {
    this.funcionImplemento = funcionImplemento;
}

public String getObservacionesImplemento() {
    return observacionesImplemento;
}

public void setObservacionesImplemento(String observacionesImplemento) {
    this.observacionesImplemento = observacionesImplemento;
}

public String getEstadoImplemento() {
    return estadoImplemento;
}

public void setEstadoImplemento(String estadoImplemento) {
    this.estadoImplemento = estadoImplemento;
}

public List<Bitacora> getBitacora() {
    return Bitacora;
}

public void setBitacora(List<Bitacora> bitacora) {
    Bitacora = bitacora;
}

public List<Categoria> getCategoria() {
    return Categoria;
}

public void setCategoria(List<Categoria> categoria) {
    Categoria = categoria;
}


}
