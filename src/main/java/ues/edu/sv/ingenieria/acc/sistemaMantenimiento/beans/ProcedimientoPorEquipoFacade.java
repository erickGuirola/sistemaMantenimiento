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
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipo;

/**
 *
 * @author erick
 */
@Stateless
public class ProcedimientoPorEquipoFacade extends AbstractFacade<ProcedimientoPorEquipo> implements ProcedimientoPorEquipoFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserTransaction transaccion;
    private List<ProcedimientoPorEquipo> procedimientoPorEquipoList;
    private Query query;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcedimientoPorEquipoFacade() {
        super(ProcedimientoPorEquipo.class);
    }

    @Override
    protected UserTransaction getTransaction() {
     return transaccion;
    }

    @Override
    public List<ProcedimientoPorEquipo> findByProcedimientos() {
           query = em.createNamedQuery("ProcedimientoPorEquipo.findByProcedimientoPorEquipo");
           procedimientoPorEquipoList = query.getResultList();
           System.out.println("Enviado desde logica de Negocio ");
           
           return procedimientoPorEquipoList;

    }
    
}
