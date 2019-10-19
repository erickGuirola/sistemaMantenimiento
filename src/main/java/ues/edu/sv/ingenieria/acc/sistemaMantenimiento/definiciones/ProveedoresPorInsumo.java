/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "proveedores_por_insumo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedoresPorInsumo.findAll", query = "SELECT p FROM ProveedoresPorInsumo p")
    , @NamedQuery(name = "ProveedoresPorInsumo.findByIdMaterialInsumo", query = "SELECT p FROM ProveedoresPorInsumo p WHERE p.proveedoresPorInsumoPK.idMaterialInsumo = :idMaterialInsumo")
    , @NamedQuery(name = "ProveedoresPorInsumo.findByIdProveedor", query = "SELECT p FROM ProveedoresPorInsumo p WHERE p.proveedoresPorInsumoPK.idProveedor = :idProveedor")
    , @NamedQuery(name = "ProveedoresPorInsumo.findByObservaciones", query = "SELECT p FROM ProveedoresPorInsumo p WHERE p.observaciones = :observaciones")})
public class ProveedoresPorInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProveedoresPorInsumoPK proveedoresPorInsumoPK;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @JoinColumn(name = "id_material_insumo", referencedColumnName = "id_material_insumo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MaterialesInsumos materialesInsumos;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedores proveedores;

    public ProveedoresPorInsumo() {
    }

    public ProveedoresPorInsumo(ProveedoresPorInsumoPK proveedoresPorInsumoPK) {
        this.proveedoresPorInsumoPK = proveedoresPorInsumoPK;
    }

    public ProveedoresPorInsumo(int idMaterialInsumo, int idProveedor) {
        this.proveedoresPorInsumoPK = new ProveedoresPorInsumoPK(idMaterialInsumo, idProveedor);
    }

    public ProveedoresPorInsumoPK getProveedoresPorInsumoPK() {
        return proveedoresPorInsumoPK;
    }

    public void setProveedoresPorInsumoPK(ProveedoresPorInsumoPK proveedoresPorInsumoPK) {
        this.proveedoresPorInsumoPK = proveedoresPorInsumoPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public MaterialesInsumos getMaterialesInsumos() {
        return materialesInsumos;
    }

    public void setMaterialesInsumos(MaterialesInsumos materialesInsumos) {
        this.materialesInsumos = materialesInsumos;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedoresPorInsumoPK != null ? proveedoresPorInsumoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedoresPorInsumo)) {
            return false;
        }
        ProveedoresPorInsumo other = (ProveedoresPorInsumo) object;
        if ((this.proveedoresPorInsumoPK == null && other.proveedoresPorInsumoPK != null) || (this.proveedoresPorInsumoPK != null && !this.proveedoresPorInsumoPK.equals(other.proveedoresPorInsumoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProveedoresPorInsumo[ proveedoresPorInsumoPK=" + proveedoresPorInsumoPK + " ]";
    }
    
}
