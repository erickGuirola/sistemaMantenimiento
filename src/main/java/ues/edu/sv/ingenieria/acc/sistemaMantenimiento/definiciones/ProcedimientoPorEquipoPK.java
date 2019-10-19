/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author erick
 */
@Embeddable
public class ProcedimientoPorEquipoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_procedimiento", nullable = false)
    private int idProcedimiento;
    @Basic(optional = false)
    @Column(name = "id_equipo", nullable = false)
    private int idEquipo;
    @Basic(optional = false)
    @Column(name = "id_material_insumo", nullable = false)
    private int idMaterialInsumo;

    public ProcedimientoPorEquipoPK() {
    }

    public ProcedimientoPorEquipoPK(int idProcedimiento, int idEquipo, int idMaterialInsumo) {
        this.idProcedimiento = idProcedimiento;
        this.idEquipo = idEquipo;
        this.idMaterialInsumo = idMaterialInsumo;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdMaterialInsumo() {
        return idMaterialInsumo;
    }

    public void setIdMaterialInsumo(int idMaterialInsumo) {
        this.idMaterialInsumo = idMaterialInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProcedimiento;
        hash += (int) idEquipo;
        hash += (int) idMaterialInsumo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimientoPorEquipoPK)) {
            return false;
        }
        ProcedimientoPorEquipoPK other = (ProcedimientoPorEquipoPK) object;
        if (this.idProcedimiento != other.idProcedimiento) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idMaterialInsumo != other.idMaterialInsumo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipoPK[ idProcedimiento=" + idProcedimiento + ", idEquipo=" + idEquipo + ", idMaterialInsumo=" + idMaterialInsumo + " ]";
    }
    
}
