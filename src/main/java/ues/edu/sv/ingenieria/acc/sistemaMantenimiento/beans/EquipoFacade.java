/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.Equipo;

/**
 *
 * @author erick
 */
@Stateless
public class EquipoFacade extends AbstractFacade<Equipo> implements EquipoFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoFacade() {
        super(Equipo.class);
    }
    
}
