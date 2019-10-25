
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans.RecursoHumanoFacadeLocal;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.RecursoHumano;

/**
 *
 * @author erick
 */

@ManagedBean(name="recursoHumano")
@ApplicationScoped
public class RecursoHumanoController  implements Serializable{
 

private List<RecursoHumano> listaRecursos;  

@Inject
RecursoHumanoFacadeLocal recursoFacade;
        
    public RecursoHumanoController() {
    
    }
   
    
    @PostConstruct
    public void inicio(){
      
      listaRecursos = recursoFacade.findAll();
     
      
    }

  
    
    public List<RecursoHumano> getListaRecursos() {
        return listaRecursos;
    }

    
    public void setListaRecursos(List<RecursoHumano> listaRecursos) {
        this.listaRecursos = listaRecursos;
    }
    
    
    
}
