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
@Table(name = "partes_por_equipo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartesPorEquipo.findAll", query = "SELECT p FROM PartesPorEquipo p")
    , @NamedQuery(name = "PartesPorEquipo.findByIdEquipo", query = "SELECT p FROM PartesPorEquipo p WHERE p.partesPorEquipoPK.idEquipo = :idEquipo")
    , @NamedQuery(name = "PartesPorEquipo.findByIdParte", query = "SELECT p FROM PartesPorEquipo p WHERE p.partesPorEquipoPK.idParte = :idParte")
    , @NamedQuery(name = "PartesPorEquipo.findByCantidad", query = "SELECT p FROM PartesPorEquipo p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "PartesPorEquipo.findByObservaciones", query = "SELECT p FROM PartesPorEquipo p WHERE p.observaciones = :observaciones")})
public class PartesPorEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartesPorEquipoPK partesPorEquipoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partes partes;

    public PartesPorEquipo() {
    }

    public PartesPorEquipo(PartesPorEquipoPK partesPorEquipoPK) {
        this.partesPorEquipoPK = partesPorEquipoPK;
    }

    public PartesPorEquipo(PartesPorEquipoPK partesPorEquipoPK, int cantidad) {
        this.partesPorEquipoPK = partesPorEquipoPK;
        this.cantidad = cantidad;
    }

    public PartesPorEquipo(int idEquipo, int idParte) {
        this.partesPorEquipoPK = new PartesPorEquipoPK(idEquipo, idParte);
    }

    public PartesPorEquipoPK getPartesPorEquipoPK() {
        return partesPorEquipoPK;
    }

    public void setPartesPorEquipoPK(PartesPorEquipoPK partesPorEquipoPK) {
        this.partesPorEquipoPK = partesPorEquipoPK;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partes getPartes() {
        return partes;
    }

    public void setPartes(Partes partes) {
        this.partes = partes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partesPorEquipoPK != null ? partesPorEquipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartesPorEquipo)) {
            return false;
        }
        PartesPorEquipo other = (PartesPorEquipo) object;
        if ((this.partesPorEquipoPK == null && other.partesPorEquipoPK != null) || (this.partesPorEquipoPK != null && !this.partesPorEquipoPK.equals(other.partesPorEquipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.PartesPorEquipo[ partesPorEquipoPK=" + partesPorEquipoPK + " ]";
    }
    
}
