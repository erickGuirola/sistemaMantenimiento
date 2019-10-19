/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProveedoresPorInsumo;

/**
 *
 * @author erick
 */
@Stateless
public class ProveedoresPorInsumoFacade extends AbstractFacade<ProveedoresPorInsumo> implements ProveedoresPorInsumoFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresPorInsumoFacade() {
        super(ProveedoresPorInsumo.class);
    }
    
}
