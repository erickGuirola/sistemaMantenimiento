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
@Table(name = "procedimiento", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p")
    , @NamedQuery(name = "Procedimiento.findByIdProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.idProcedimiento = :idProcedimiento")
    , @NamedQuery(name = "Procedimiento.findByProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.procedimiento = :procedimiento")
    , @NamedQuery(name = "Procedimiento.findByDescripcion", query = "SELECT p FROM Procedimiento p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Procedimiento.findByObservaciones", query = "SELECT p FROM Procedimiento p WHERE p.observaciones = :observaciones")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedimiento", nullable = false)
    private Integer idProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "procedimiento", nullable = false, length = 50)
    private String procedimiento;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimiento")
    private List<OrdenTrabajo> ordenTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedimiento")
    private List<ProcedimientoPorEquipo> procedimientoPorEquipoList;

    public Procedimiento() {
    }

    public Procedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Procedimiento(Integer idProcedimiento, String procedimiento) {
        this.idProcedimiento = idProcedimiento;
        this.procedimiento = procedimiento;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
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
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @JsonbTransient
    @XmlTransient
    public List<ProcedimientoPorEquipo> getProcedimientoPorEquipoList() {
        return procedimientoPorEquipoList;
    }

    public void setProcedimientoPorEquipoList(List<ProcedimientoPorEquipo> procedimientoPorEquipoList) {
        this.procedimientoPorEquipoList = procedimientoPorEquipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Procedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
