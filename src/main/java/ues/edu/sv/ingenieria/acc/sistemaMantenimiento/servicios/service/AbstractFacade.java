
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author erick
 */

public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU");
    EntityManager entitymanager = emfactory.createEntityManager();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
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

    public List<T> findByEstado(int estado){
      Query query = entitymanager.createNamedQuery("OrdenTrabajo.findByEstado");
      query.setParameter("idEstado", estado);
      
      List<T> list = query.getResultList( );
         
        return list;
     } 
    
    public List<T> findByProcedimientos(){
      Query query = entitymanager.createNamedQuery("ProcedimientoPorEquipo.findByProcedimientoPorEquipo");
      
      List<T> list = query.getResultList();
      return list;
    }
    
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
