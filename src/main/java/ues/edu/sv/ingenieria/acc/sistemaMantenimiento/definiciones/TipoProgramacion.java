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
@Table(name = "tipo_programacion", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProgramacion.findAll", query = "SELECT t FROM TipoProgramacion t")
    , @NamedQuery(name = "TipoProgramacion.findByIdTipoProgramacion", query = "SELECT t FROM TipoProgramacion t WHERE t.idTipoProgramacion = :idTipoProgramacion")
    , @NamedQuery(name = "TipoProgramacion.findByProgramacion", query = "SELECT t FROM TipoProgramacion t WHERE t.programacion = :programacion")
    , @NamedQuery(name = "TipoProgramacion.findByObservaciones", query = "SELECT t FROM TipoProgramacion t WHERE t.observaciones = :observaciones")})
public class TipoProgramacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_programacion", nullable = false)
    private Integer idTipoProgramacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "programacion", nullable = false, length = 50)
    private String programacion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProgramacion")
    private List<Programacion> programacionList;

    public TipoProgramacion() {
    }

    public TipoProgramacion(Integer idTipoProgramacion) {
        this.idTipoProgramacion = idTipoProgramacion;
    }

    public TipoProgramacion(Integer idTipoProgramacion, String programacion) {
        this.idTipoProgramacion = idTipoProgramacion;
        this.programacion = programacion;
    }

    public Integer getIdTipoProgramacion() {
        return idTipoProgramacion;
    }

    public void setIdTipoProgramacion(Integer idTipoProgramacion) {
        this.idTipoProgramacion = idTipoProgramacion;
    }

    public String getProgramacion() {
        return programacion;
    }

    public void setProgramacion(String programacion) {
        this.programacion = programacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonbTransient
    public List<Programacion> getProgramacionList() {
        return programacionList;
    }

    public void setProgramacionList(List<Programacion> programacionList) {
        this.programacionList = programacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProgramacion != null ? idTipoProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProgramacion)) {
            return false;
        }
        TipoProgramacion other = (TipoProgramacion) object;
        if ((this.idTipoProgramacion == null && other.idTipoProgramacion != null) || (this.idTipoProgramacion != null && !this.idTipoProgramacion.equals(other.idTipoProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.TipoProgramacion[ idTipoProgramacion=" + idTipoProgramacion + " ]";
    }
    
}
