/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenTrabajo;

/**
 *
 * @author erick
 */
@Stateless
public class OrdenTrabajoFacade extends AbstractFacade<OrdenTrabajo> implements OrdenTrabajoFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserTransaction transaccion;
    private List<OrdenTrabajo> ordenTrabajoList;
    private Query query;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenTrabajoFacade() {
        super(OrdenTrabajo.class);
    }

    @Override
    protected UserTransaction getTransaction() {
        return transaccion;
    }

    @Override
    public List<OrdenTrabajo> findByEstado(int estado) {
       query = em.createNamedQuery("OrdenTrabajo.findByEstado");
       query.setParameter("idEstado", estado);
       ordenTrabajoList = query.getResultList();
       
       return ordenTrabajoList;
      
    }

    @Override
    public List<OrdenTrabajo> findByHistorial() {
         query = em.createNamedQuery("OrdenTrabajo.findByHistorial");
         ordenTrabajoList = query.getResultList();
         System.out.println("Enviado desde Historial Lógica de Negocio");
         return ordenTrabajoList;

    }
    
}
