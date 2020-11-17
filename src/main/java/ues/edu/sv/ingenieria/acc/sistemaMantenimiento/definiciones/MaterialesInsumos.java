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
@Table(name = "materiales_insumos", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialesInsumos.findAll", query = "SELECT m FROM MaterialesInsumos m")
    , @NamedQuery(name = "MaterialesInsumos.findByIdMaterialInsumo", query = "SELECT m FROM MaterialesInsumos m WHERE m.idMaterialInsumo = :idMaterialInsumo")
    , @NamedQuery(name = "MaterialesInsumos.findByMaterialInsumo", query = "SELECT m FROM MaterialesInsumos m WHERE m.materialInsumo = :materialInsumo")
    , @NamedQuery(name = "MaterialesInsumos.findByExistencia", query = "SELECT m FROM MaterialesInsumos m WHERE m.existencia = :existencia")
    , @NamedQuery(name = "MaterialesInsumos.findByStockMaximo", query = "SELECT m FROM MaterialesInsumos m WHERE m.stockMaximo = :stockMaximo")
    , @NamedQuery(name = "MaterialesInsumos.findByStockMinimo", query = "SELECT m FROM MaterialesInsumos m WHERE m.stockMinimo = :stockMinimo")
    , @NamedQuery(name = "MaterialesInsumos.findByObservaciones", query = "SELECT m FROM MaterialesInsumos m WHERE m.observaciones = :observaciones")})
public class MaterialesInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_insumo", nullable = false)
    private Integer idMaterialInsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "material_insumo", nullable = false, length = 50)
    private String materialInsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia", nullable = false)
    private int existencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_maximo", nullable = false)
    private int stockMaximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_minimo", nullable = false)
    private int stockMinimo;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialesInsumos")
    private List<ProcedimientoPorEquipo> procedimientoPorEquipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialesInsumos")
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialesInsumos")
    private List<ProveedoresPorInsumo> proveedoresPorInsumoList;

    public MaterialesInsumos() {
    }

    public MaterialesInsumos(Integer idMaterialInsumo) {
        this.idMaterialInsumo = idMaterialInsumo;
    }

    public MaterialesInsumos(Integer idMaterialInsumo, String materialInsumo, int existencia, int stockMaximo, int stockMinimo) {
        this.idMaterialInsumo = idMaterialInsumo;
        this.materialInsumo = materialInsumo;
        this.existencia = existencia;
        this.stockMaximo = stockMaximo;
        this.stockMinimo = stockMinimo;
    }

    public Integer getIdMaterialInsumo() {
        return idMaterialInsumo;
    }

    public void setIdMaterialInsumo(Integer idMaterialInsumo) {
        this.idMaterialInsumo = idMaterialInsumo;
    }

    public String getMaterialInsumo() {
        return materialInsumo;
    }

    public void setMaterialInsumo(String materialInsumo) {
        this.materialInsumo = materialInsumo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonbTransient
    @XmlTransient
    public List<ProcedimientoPorEquipo> getProcedimientoPorEquipoList() {
        return procedimientoPorEquipoList;
    }

    public void setProcedimientoPorEquipoList(List<ProcedimientoPorEquipo> procedimientoPorEquipoList) {
        this.procedimientoPorEquipoList = procedimientoPorEquipoList;
    }

   @JsonbTransient
    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @JsonbTransient
    @XmlTransient
    public List<ProveedoresPorInsumo> getProveedoresPorInsumoList() {
        return proveedoresPorInsumoList;
    }

    public void setProveedoresPorInsumoList(List<ProveedoresPorInsumo> proveedoresPorInsumoList) {
        this.proveedoresPorInsumoList = proveedoresPorInsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialInsumo != null ? idMaterialInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialesInsumos)) {
            return false;
        }
        MaterialesInsumos other = (MaterialesInsumos) object;
        if ((this.idMaterialInsumo == null && other.idMaterialInsumo != null) || (this.idMaterialInsumo != null && !this.idMaterialInsumo.equals(other.idMaterialInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.MaterialesInsumos[ idMaterialInsumo=" + idMaterialInsumo + " ]";
    }
    
}
