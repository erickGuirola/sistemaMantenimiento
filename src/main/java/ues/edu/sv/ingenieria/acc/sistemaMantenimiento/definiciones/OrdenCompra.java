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
@Table(name = "orden_compra", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o")
    , @NamedQuery(name = "OrdenCompra.findByIdOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.ordenCompraPK.idOrdenCompra = :idOrdenCompra")
    , @NamedQuery(name = "OrdenCompra.findByIdProveedor", query = "SELECT o FROM OrdenCompra o WHERE o.ordenCompraPK.idProveedor = :idProveedor")
    , @NamedQuery(name = "OrdenCompra.findByIdMaterialInsumo", query = "SELECT o FROM OrdenCompra o WHERE o.ordenCompraPK.idMaterialInsumo = :idMaterialInsumo")
    , @NamedQuery(name = "OrdenCompra.findByCantidad", query = "SELECT o FROM OrdenCompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenCompra.findByObservaciones", query = "SELECT o FROM OrdenCompra o WHERE o.observaciones = :observaciones")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenCompraPK ordenCompraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @JoinColumn(name = "id_material_insumo", referencedColumnName = "id_material_insumo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MaterialesInsumos materialesInsumos;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedores proveedores;

    public OrdenCompra() {
    }

    public OrdenCompra(OrdenCompraPK ordenCompraPK) {
        this.ordenCompraPK = ordenCompraPK;
    }

    public OrdenCompra(OrdenCompraPK ordenCompraPK, int cantidad) {
        this.ordenCompraPK = ordenCompraPK;
        this.cantidad = cantidad;
    }

    public OrdenCompra(int idOrdenCompra, int idProveedor, int idMaterialInsumo) {
        this.ordenCompraPK = new OrdenCompraPK(idOrdenCompra, idProveedor, idMaterialInsumo);
    }

    public OrdenCompraPK getOrdenCompraPK() {
        return ordenCompraPK;
    }

    public void setOrdenCompraPK(OrdenCompraPK ordenCompraPK) {
        this.ordenCompraPK = ordenCompraPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        hash += (ordenCompraPK != null ? ordenCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.ordenCompraPK == null && other.ordenCompraPK != null) || (this.ordenCompraPK != null && !this.ordenCompraPK.equals(other.ordenCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompra[ ordenCompraPK=" + ordenCompraPK + " ]";
    }
    
}
