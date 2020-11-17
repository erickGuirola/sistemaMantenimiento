
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallas;

/**
 *
 * @author erick
 */
@Stateless
public class BitacoraDeFallasFacade extends AbstractFacade<BitacoraDeFallas> implements BitacoraDeFallasFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitacoraDeFallasFacade() {
        super(BitacoraDeFallas.class);
    }

    @Override
    protected UserTransaction getTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
