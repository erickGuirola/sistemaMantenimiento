/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "programacion", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programacion.findAll", query = "SELECT p FROM Programacion p")
    , @NamedQuery(name = "Programacion.findByIdProgramacion", query = "SELECT p FROM Programacion p WHERE p.idProgramacion = :idProgramacion")
    , @NamedQuery(name = "Programacion.findByFechaRealizacion", query = "SELECT p FROM Programacion p WHERE p.fechaRealizacion = :fechaRealizacion")
    , @NamedQuery(name = "Programacion.findByObservaciones", query = "SELECT p FROM Programacion p WHERE p.observaciones = :observaciones")})
public class Programacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_programacion", nullable = false)
    private Integer idProgramacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_realizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private OrdenTrabajo idOrdenTrabajo;
    @JoinColumn(name = "id_tipo_programacion", referencedColumnName = "id_tipo_programacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoProgramacion idTipoProgramacion;

    public Programacion() {
    }

    public Programacion(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Programacion(Integer idProgramacion, Date fechaRealizacion) {
        this.idProgramacion = idProgramacion;
        this.fechaRealizacion = fechaRealizacion;
    }

    public Integer getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public OrdenTrabajo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenTrabajo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public TipoProgramacion getIdTipoProgramacion() {
        return idTipoProgramacion;
    }

    public void setIdTipoProgramacion(TipoProgramacion idTipoProgramacion) {
        this.idTipoProgramacion = idTipoProgramacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgramacion != null ? idProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacion)) {
            return false;
        }
        Programacion other = (Programacion) object;
        if ((this.idProgramacion == null && other.idProgramacion != null) || (this.idProgramacion != null && !this.idProgramacion.equals(other.idProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Programacion[ idProgramacion=" + idProgramacion + " ]";
    }
    
}
