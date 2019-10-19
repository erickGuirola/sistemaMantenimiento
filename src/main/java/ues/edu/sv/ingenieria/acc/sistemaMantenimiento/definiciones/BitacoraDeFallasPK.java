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
public class BitacoraDeFallasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_equipo", nullable = false)
    private int idEquipo;
    @Basic(optional = false)
    @Column(name = "id_falla", nullable = false)
    private int idFalla;

    public BitacoraDeFallasPK() {
    }

    public BitacoraDeFallasPK(int idEquipo, int idFalla) {
        this.idEquipo = idEquipo;
        this.idFalla = idFalla;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(int idFalla) {
        this.idFalla = idFalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idFalla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraDeFallasPK)) {
            return false;
        }
        BitacoraDeFallasPK other = (BitacoraDeFallasPK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idFalla != other.idFalla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallasPK[ idEquipo=" + idEquipo + ", idFalla=" + idFalla + " ]";
    }
    
}
