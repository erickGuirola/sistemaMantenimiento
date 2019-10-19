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
public class OrdenCompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_orden_compra", nullable = false)
    private int idOrdenCompra;
    @Basic(optional = false)
    @Column(name = "id_proveedor", nullable = false)
    private int idProveedor;
    @Basic(optional = false)
    @Column(name = "id_material_insumo", nullable = false)
    private int idMaterialInsumo;

    public OrdenCompraPK() {
    }

    public OrdenCompraPK(int idOrdenCompra, int idProveedor, int idMaterialInsumo) {
        this.idOrdenCompra = idOrdenCompra;
        this.idProveedor = idProveedor;
        this.idMaterialInsumo = idMaterialInsumo;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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
        hash += (int) idOrdenCompra;
        hash += (int) idProveedor;
        hash += (int) idMaterialInsumo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraPK)) {
            return false;
        }
        OrdenCompraPK other = (OrdenCompraPK) object;
        if (this.idOrdenCompra != other.idOrdenCompra) {
            return false;
        }
        if (this.idProveedor != other.idProveedor) {
            return false;
        }
        if (this.idMaterialInsumo != other.idMaterialInsumo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompraPK[ idOrdenCompra=" + idOrdenCompra + ", idProveedor=" + idProveedor + ", idMaterialInsumo=" + idMaterialInsumo + " ]";
    }
    
}
