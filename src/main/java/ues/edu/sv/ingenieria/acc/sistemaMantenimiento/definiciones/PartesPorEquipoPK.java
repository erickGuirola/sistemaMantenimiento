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
public class PartesPorEquipoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_equipo", nullable = false)
    private int idEquipo;
    @Basic(optional = false)
    @Column(name = "id_parte", nullable = false)
    private int idParte;

    public PartesPorEquipoPK() {
    }

    public PartesPorEquipoPK(int idEquipo, int idParte) {
        this.idEquipo = idEquipo;
        this.idParte = idParte;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idParte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartesPorEquipoPK)) {
            return false;
        }
        PartesPorEquipoPK other = (PartesPorEquipoPK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idParte != other.idParte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.PartesPorEquipoPK[ idEquipo=" + idEquipo + ", idParte=" + idParte + " ]";
    }
    
}
