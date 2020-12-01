/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "orden_trabajo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajo o WHERE o.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaGeneracion", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaGeneracion = :fechaGeneracion")
    , @NamedQuery(name = "OrdenTrabajo.findByObservaciones", query = "SELECT o FROM OrdenTrabajo o WHERE o.observaciones = :observaciones")
    , @NamedQuery(name = "OrdenTrabajo.findByEstado", query = "SELECT p.idOrdenTrabajo,p.fechaGeneracion, CONCAT(rh.nombre,'  ',rh.apellido),tm.mantenimiento,proc.procedimiento, t.estado FROM OrdenTrabajo p JOIN p.idEstado t JOIN p.idRecursoHumano rh JOIN p.idTipoMantenimiento tm JOIN p.idProcedimiento proc where t.idEstado = :idEstado")
    , @NamedQuery(name = "OrdenTrabajo.findByHistorial", query = "SELECT p.idOrdenTrabajo,p.fechaGeneracion, CONCAT(rh.nombre,'  ',rh.apellido),tm.mantenimiento,proc.procedimiento, t.estado FROM OrdenTrabajo p JOIN p.idEstado t JOIN p.idRecursoHumano rh JOIN p.idTipoMantenimiento tm JOIN p.idProcedimiento proc ")})

public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo", nullable = false)
    private Integer idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_generacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    @ManyToOne(optional = false)
    private EstadoOrdenTrabajo idEstado;
    
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento", nullable = false)
    @ManyToOne(optional = false)
    private Procedimiento idProcedimiento;
    @JoinColumn(name = "id_recurso_humano", referencedColumnName = "id_recurso_humano", nullable = false)
    @ManyToOne(optional = false)
    private RecursoHumano idRecursoHumano;
    @JoinColumn(name = "id_tipo_mantenimiento", referencedColumnName = "id_tipo_mantenimiento", nullable = false)
    @ManyToOne(optional = false)
    private TipoMantenimiento idTipoMantenimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenTrabajo")
    private List<Programacion> programacionList;

    public OrdenTrabajo() {
    }

//    public OrdenTrabajo(Integer idOrdenTrabajo) {
//        this.idOrdenTrabajo = idOrdenTrabajo;
//    }
//
//    public OrdenTrabajo(Integer idOrdenTrabajo, Date fechaGeneracion) {
//        this.idOrdenTrabajo = idOrdenTrabajo;
//        this.fechaGeneracion = fechaGeneracion;
//    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
    
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoOrdenTrabajo getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoOrdenTrabajo idEstado) {
        this.idEstado = idEstado;
    }
    
    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Procedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Procedimiento idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public RecursoHumano getIdRecursoHumano() {
        return idRecursoHumano;
    }

    public void setIdRecursoHumano(RecursoHumano idRecursoHumano) {
        this.idRecursoHumano = idRecursoHumano;
    }

    public TipoMantenimiento getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(TipoMantenimiento idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    @JsonbTransient
    @XmlTransient
    public List<Programacion> getProgramacionList() {
        return programacionList;
    }

    public void setProgramacionList(List<Programacion> programacionList) {
        this.programacionList = programacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenTrabajo[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
