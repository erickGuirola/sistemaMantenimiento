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
@Table(name = "proveedores", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByIdProveedor", query = "SELECT p FROM Proveedores p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "Proveedores.findByProveedor", query = "SELECT p FROM Proveedores p WHERE p.proveedor = :proveedor")
    , @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedores.findByObservaciones", query = "SELECT p FROM Proveedores p WHERE p.observaciones = :observaciones")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor", nullable = false)
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "proveedor", nullable = false, length = 50)
    private String proveedor;
    @Size(max = 8)
    @Column(name = "telefono", length = 8)
    private String telefono;
    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedores")
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedores")
    private List<ProveedoresPorInsumo> proveedoresPorInsumoList;

    public Proveedores() {
    }

    public Proveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedores(Integer idProveedor, String proveedor) {
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonbTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @JsonbTransient
    public List<ProveedoresPorInsumo> getProveedoresPorInsumoList() {
        return proveedoresPorInsumoList;
    }

    public void setProveedoresPorInsumoList(List<ProveedoresPorInsumo> proveedoresPorInsumoList) {
        this.proveedoresPorInsumoList = proveedoresPorInsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Proveedores[ idProveedor=" + idProveedor + " ]";
    }
    
}
