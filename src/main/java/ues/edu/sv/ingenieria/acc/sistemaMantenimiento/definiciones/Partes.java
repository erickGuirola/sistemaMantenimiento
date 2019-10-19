/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "partes", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partes.findAll", query = "SELECT p FROM Partes p")
    , @NamedQuery(name = "Partes.findByIdParte", query = "SELECT p FROM Partes p WHERE p.idParte = :idParte")
    , @NamedQuery(name = "Partes.findByParte", query = "SELECT p FROM Partes p WHERE p.parte = :parte")
    , @NamedQuery(name = "Partes.findByDescripcion", query = "SELECT p FROM Partes p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Partes.findByObservaciones", query = "SELECT p FROM Partes p WHERE p.observaciones = :observaciones")})
public class Partes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parte", nullable = false)
    private Integer idParte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "parte", nullable = false, length = 50)
    private String parte;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partes")
    private List<PartesPorEquipo> partesPorEquipoList;

    public Partes() {
    }

    public Partes(Integer idParte) {
        this.idParte = idParte;
    }

    public Partes(Integer idParte, String parte) {
        this.idParte = idParte;
        this.parte = parte;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
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
        hash += (idParte != null ? idParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partes)) {
            return false;
        }
        Partes other = (Partes) object;
        if ((this.idParte == null && other.idParte != null) || (this.idParte != null && !this.idParte.equals(other.idParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Partes[ idParte=" + idParte + " ]";
    }
    
}
