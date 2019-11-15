
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import java.util.List;


/**
 *
 * @author erick
 */
public interface AbstractFacadeInterface<T> {
    
    void create(T objeto);

    void edit(T objeto);

    void remove(T objeto);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
    
    
    
    
}
