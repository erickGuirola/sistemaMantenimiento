
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;


/**
 *
 * @author erick
 */

public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        
    }

    protected abstract UserTransaction getTransaction();
    protected abstract EntityManager getEntityManager();
    
    public boolean crear(T entity){
        
        try {
            
            UserTransaction transaccion = getTransaction();
            transaccion.begin();
            getEntityManager().persist(entity);
            transaccion.commit();
            return true;
        
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        
    }
     
    public boolean editar(T entity){
        
        try {
            UserTransaction transaction = getTransaction();
            transaction.begin();
            getEntityManager().merge(entity);
            transaction.commit();
             return true;
             
        } catch (Exception e) {
         Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, e);
         return false;
        }
        
    }
    
    public boolean eliminar(T entity){
        try {
            UserTransaction transaction = getTransaction();
            transaction.begin();;
            getEntityManager().remove(getEntityManager().merge(entity));
            transaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

  
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
  
  
}
