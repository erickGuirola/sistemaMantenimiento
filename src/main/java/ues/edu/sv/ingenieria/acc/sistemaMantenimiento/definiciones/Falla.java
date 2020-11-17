/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "falla", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Falla.findAll", query = "SELECT f FROM Falla f")
    , @NamedQuery(name = "Falla.findByIdFalla", query = "SELECT f FROM Falla f WHERE f.idFalla = :idFalla")
    , @NamedQuery(name = "Falla.findByDescripcion", query = "SELECT f FROM Falla f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "Falla.findByObservaciones", query = "SELECT f FROM Falla f WHERE f.observaciones = :observaciones")})
public class Falla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_falla", nullable = false)
    private Integer idFalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "falla")
    private List<BitacoraDeFallas> bitacoraDeFallasList;
    @JoinColumn(name = "id_tipo_falla", referencedColumnName = "id_tipo_falla", nullable = false)
    @ManyToOne(optional = false)
    private TipoFalla idTipoFalla;

    public Falla() {
    }

    public Falla(Integer idFalla) {
        this.idFalla = idFalla;
    }

    public Falla(Integer idFalla, String descripcion) {
        this.idFalla = idFalla;
        this.descripcion = descripcion;
    }

    public Integer getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(Integer idFalla) {
        this.idFalla = idFalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonbTransient
    @XmlTransient
    public List<BitacoraDeFallas> getBitacoraDeFallasList() {
        return bitacoraDeFallasList;
    }

    public void setBitacoraDeFallasList(List<BitacoraDeFallas> bitacoraDeFallasList) {
        this.bitacoraDeFallasList = bitacoraDeFallasList;
    }

    public TipoFalla getIdTipoFalla() {
        return idTipoFalla;
    }

    public void setIdTipoFalla(TipoFalla idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFalla != null ? idFalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Falla)) {
            return false;
        }
        Falla other = (Falla) object;
        if ((this.idFalla == null && other.idFalla != null) || (this.idFalla != null && !this.idFalla.equals(other.idFalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Falla[ idFalla=" + idFalla + " ]";
    }
    
}
