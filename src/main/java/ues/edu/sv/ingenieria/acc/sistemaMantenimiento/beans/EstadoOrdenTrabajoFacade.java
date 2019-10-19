/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.EstadoOrdenTrabajo;

/**
 *
 * @author erick
 */
@Stateless
public class EstadoOrdenTrabajoFacade extends AbstractFacade<EstadoOrdenTrabajo> implements EstadoOrdenTrabajoFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoOrdenTrabajoFacade() {
        super(EstadoOrdenTrabajo.class);
    }
    
}
