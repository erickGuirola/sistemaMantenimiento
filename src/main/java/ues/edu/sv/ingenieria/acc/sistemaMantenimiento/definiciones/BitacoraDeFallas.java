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
@Table(name = "bitacora_de_fallas", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BitacoraDeFallas.findAll", query = "SELECT b FROM BitacoraDeFallas b")
    , @NamedQuery(name = "BitacoraDeFallas.findByIdEquipo", query = "SELECT b FROM BitacoraDeFallas b WHERE b.bitacoraDeFallasPK.idEquipo = :idEquipo")
    , @NamedQuery(name = "BitacoraDeFallas.findByIdFalla", query = "SELECT b FROM BitacoraDeFallas b WHERE b.bitacoraDeFallasPK.idFalla = :idFalla")
    , @NamedQuery(name = "BitacoraDeFallas.findByObservaciones", query = "SELECT b FROM BitacoraDeFallas b WHERE b.observaciones = :observaciones")})
public class BitacoraDeFallas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BitacoraDeFallasPK bitacoraDeFallasPK;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "id_falla", referencedColumnName = "id_falla", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Falla falla;

    public BitacoraDeFallas() {
    }

    public BitacoraDeFallas(BitacoraDeFallasPK bitacoraDeFallasPK) {
        this.bitacoraDeFallasPK = bitacoraDeFallasPK;
    }

    public BitacoraDeFallas(int idEquipo, int idFalla) {
        this.bitacoraDeFallasPK = new BitacoraDeFallasPK(idEquipo, idFalla);
    }

    public BitacoraDeFallasPK getBitacoraDeFallasPK() {
        return bitacoraDeFallasPK;
    }

    public void setBitacoraDeFallasPK(BitacoraDeFallasPK bitacoraDeFallasPK) {
        this.bitacoraDeFallasPK = bitacoraDeFallasPK;
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

    public Falla getFalla() {
        return falla;
    }

    public void setFalla(Falla falla) {
        this.falla = falla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitacoraDeFallasPK != null ? bitacoraDeFallasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraDeFallas)) {
            return false;
        }
        BitacoraDeFallas other = (BitacoraDeFallas) object;
        if ((this.bitacoraDeFallasPK == null && other.bitacoraDeFallasPK != null) || (this.bitacoraDeFallasPK != null && !this.bitacoraDeFallasPK.equals(other.bitacoraDeFallasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallas[ bitacoraDeFallasPK=" + bitacoraDeFallasPK + " ]";
    }
    
}
