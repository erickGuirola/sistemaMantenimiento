
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import java.util.List;


/**
 *
 * @author erick
 */
public interface AbstractFacadeInterface<T> {
    
    boolean crear(T entity);
    
    boolean editar(T entity);
    
    boolean eliminar(T entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);
  
    int count();
    
}
