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
@Table(name = "estado_orden_trabajo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "EstadoOrdenTrabajo.findAll", query = "SELECT e FROM EstadoOrdenTrabajo e")
    , @NamedQuery(name = "EstadoOrdenTrabajo.findByIdEstado", query = "SELECT e FROM EstadoOrdenTrabajo e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoOrdenTrabajo.findByEstado", query = "SELECT e FROM EstadoOrdenTrabajo e WHERE e.estado = :estado")
    , @NamedQuery(name = "EstadoOrdenTrabajo.findByObservaciones", query = "SELECT e FROM EstadoOrdenTrabajo e WHERE e.observaciones = :observaciones")})
public class EstadoOrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<OrdenTrabajo> ordenTrabajoList;

    public EstadoOrdenTrabajo() {
    }

    public EstadoOrdenTrabajo(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoOrdenTrabajo(Integer idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonbTransient
    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrdenTrabajo)) {
            return false;
        }
        EstadoOrdenTrabajo other = (EstadoOrdenTrabajo) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.EstadoOrdenTrabajo[ idEstado=" + idEstado + " ]";
    }
    
}
