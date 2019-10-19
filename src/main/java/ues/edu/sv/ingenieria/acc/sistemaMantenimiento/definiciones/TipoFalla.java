/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo_falla", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFalla.findAll", query = "SELECT t FROM TipoFalla t")
    , @NamedQuery(name = "TipoFalla.findByIdTipoFalla", query = "SELECT t FROM TipoFalla t WHERE t.idTipoFalla = :idTipoFalla")
    , @NamedQuery(name = "TipoFalla.findByNombreTipoFalla", query = "SELECT t FROM TipoFalla t WHERE t.nombreTipoFalla = :nombreTipoFalla")
    , @NamedQuery(name = "TipoFalla.findByObservaciones", query = "SELECT t FROM TipoFalla t WHERE t.observaciones = :observaciones")})
public class TipoFalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_falla", nullable = false)
    private Integer idTipoFalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_tipo_falla", nullable = false, length = 50)
    private String nombreTipoFalla;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFalla")
    private List<Falla> fallaList;

    public TipoFalla() {
    }

    public TipoFalla(Integer idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    public TipoFalla(Integer idTipoFalla, String nombreTipoFalla) {
        this.idTipoFalla = idTipoFalla;
        this.nombreTipoFalla = nombreTipoFalla;
    }

    public Integer getIdTipoFalla() {
        return idTipoFalla;
    }

    public void setIdTipoFalla(Integer idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    public String getNombreTipoFalla() {
        return nombreTipoFalla;
    }

    public void setNombreTipoFalla(String nombreTipoFalla) {
        this.nombreTipoFalla = nombreTipoFalla;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Falla> getFallaList() {
        return fallaList;
    }

    public void setFallaList(List<Falla> fallaList) {
        this.fallaList = fallaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoFalla != null ? idTipoFalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFalla)) {
            return false;
        }
        TipoFalla other = (TipoFalla) object;
        if ((this.idTipoFalla == null && other.idTipoFalla != null) || (this.idTipoFalla != null && !this.idTipoFalla.equals(other.idTipoFalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.TipoFalla[ idTipoFalla=" + idTipoFalla + " ]";
    }
    
}
