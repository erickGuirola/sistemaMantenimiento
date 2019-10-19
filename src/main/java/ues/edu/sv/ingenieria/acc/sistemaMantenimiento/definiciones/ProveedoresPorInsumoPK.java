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
public class ProveedoresPorInsumoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_material_insumo", nullable = false)
    private int idMaterialInsumo;
    @Basic(optional = false)
    @Column(name = "id_proveedor", nullable = false)
    private int idProveedor;

    public ProveedoresPorInsumoPK() {
    }

    public ProveedoresPorInsumoPK(int idMaterialInsumo, int idProveedor) {
        this.idMaterialInsumo = idMaterialInsumo;
        this.idProveedor = idProveedor;
    }

    public int getIdMaterialInsumo() {
        return idMaterialInsumo;
    }

    public void setIdMaterialInsumo(int idMaterialInsumo) {
        this.idMaterialInsumo = idMaterialInsumo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMaterialInsumo;
        hash += (int) idProveedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedoresPorInsumoPK)) {
            return false;
        }
        ProveedoresPorInsumoPK other = (ProveedoresPorInsumoPK) object;
        if (this.idMaterialInsumo != other.idMaterialInsumo) {
            return false;
        }
        if (this.idProveedor != other.idProveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProveedoresPorInsumoPK[ idMaterialInsumo=" + idMaterialInsumo + ", idProveedor=" + idProveedor + " ]";
    }
    
}
