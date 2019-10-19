/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "procedimiento_por_equipo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedimientoPorEquipo.findAll", query = "SELECT p FROM ProcedimientoPorEquipo p")
    , @NamedQuery(name = "ProcedimientoPorEquipo.findByIdProcedimiento", query = "SELECT p FROM ProcedimientoPorEquipo p WHERE p.procedimientoPorEquipoPK.idProcedimiento = :idProcedimiento")
    , @NamedQuery(name = "ProcedimientoPorEquipo.findByIdEquipo", query = "SELECT p FROM ProcedimientoPorEquipo p WHERE p.procedimientoPorEquipoPK.idEquipo = :idEquipo")
    , @NamedQuery(name = "ProcedimientoPorEquipo.findByIdMaterialInsumo", query = "SELECT p FROM ProcedimientoPorEquipo p WHERE p.procedimientoPorEquipoPK.idMaterialInsumo = :idMaterialInsumo")
    , @NamedQuery(name = "ProcedimientoPorEquipo.findByDescripcion", query = "SELECT p FROM ProcedimientoPorEquipo p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProcedimientoPorEquipo.findByObservaciones", query = "SELECT p FROM ProcedimientoPorEquipo p WHERE p.observaciones = :observaciones")})
public class ProcedimientoPorEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimientoPorEquipoPK procedimientoPorEquipoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Size(max = 100)
    @Column(name = "observaciones", length = 100)
    private String observaciones;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "id_material_insumo", referencedColumnName = "id_material_insumo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MaterialesInsumos materialesInsumos;
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Procedimiento procedimiento;

    public ProcedimientoPorEquipo() {
    }

    public ProcedimientoPorEquipo(ProcedimientoPorEquipoPK procedimientoPorEquipoPK) {
        this.procedimientoPorEquipoPK = procedimientoPorEquipoPK;
    }

    public ProcedimientoPorEquipo(ProcedimientoPorEquipoPK procedimientoPorEquipoPK, String descripcion) {
        this.procedimientoPorEquipoPK = procedimientoPorEquipoPK;
        this.descripcion = descripcion;
    }

    public ProcedimientoPorEquipo(int idProcedimiento, int idEquipo, int idMaterialInsumo) {
        this.procedimientoPorEquipoPK = new ProcedimientoPorEquipoPK(idProcedimiento, idEquipo, idMaterialInsumo);
    }

    public ProcedimientoPorEquipoPK getProcedimientoPorEquipoPK() {
        return procedimientoPorEquipoPK;
    }

    public void setProcedimientoPorEquipoPK(ProcedimientoPorEquipoPK procedimientoPorEquipoPK) {
        this.procedimientoPorEquipoPK = procedimientoPorEquipoPK;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public MaterialesInsumos getMaterialesInsumos() {
        return materialesInsumos;
    }

    public void setMaterialesInsumos(MaterialesInsumos materialesInsumos) {
        this.materialesInsumos = materialesInsumos;
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procedimientoPorEquipoPK != null ? procedimientoPorEquipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientoPorEquipo)) {
            return false;
        }
        ProcedimientoPorEquipo other = (ProcedimientoPorEquipo) object;
        if ((this.procedimientoPorEquipoPK == null && other.procedimientoPorEquipoPK != null) || (this.procedimientoPorEquipoPK != null && !this.procedimientoPorEquipoPK.equals(other.procedimientoPorEquipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipo[ procedimientoPorEquipoPK=" + procedimientoPorEquipoPK + " ]";
    }
    
}
