/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.MaterialesInsumos;

/**
 *
 * @author erick
 */
@Stateless
public class MaterialesInsumosFacade extends AbstractFacade<MaterialesInsumos> implements MaterialesInsumosFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialesInsumosFacade() {
        super(MaterialesInsumos.class);
    }

    @Override
    protected UserTransaction getTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
