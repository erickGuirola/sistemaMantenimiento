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
@Table(name = "equipo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e ORDER BY e.idEquipo DESC")
    , @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "Equipo.findByEquipo", query = "SELECT e FROM Equipo e WHERE e.equipo = :equipo")
    , @NamedQuery(name = "Equipo.findByCantidad", query = "SELECT e FROM Equipo e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "Equipo.findByDescripcion", query = "SELECT e FROM Equipo e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Equipo.findByObservaciones", query = "SELECT e FROM Equipo e WHERE e.observaciones = :observaciones")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "equipo", nullable = false, length = 50)
    private String equipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<BitacoraDeFallas> bitacoraDeFallasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<ProcedimientoPorEquipo> procedimientoPorEquipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<PartesPorEquipo> partesPorEquipoList;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String equipo, int cantidad, String descripcion) {
        this.idEquipo = idEquipo;
        this.equipo = equipo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    public List<BitacoraDeFallas> getBitacoraDeFallasList() {
        return bitacoraDeFallasList;
    }

    public void setBitacoraDeFallasList(List<BitacoraDeFallas> bitacoraDeFallasList) {
        this.bitacoraDeFallasList = bitacoraDeFallasList;
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
    public List<PartesPorEquipo> getPartesPorEquipoList() {
        return partesPorEquipoList;
    }

    public void setPartesPorEquipoList(List<PartesPorEquipo> partesPorEquipoList) {
        this.partesPorEquipoList = partesPorEquipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
