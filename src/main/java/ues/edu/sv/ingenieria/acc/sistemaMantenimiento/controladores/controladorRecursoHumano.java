/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans.RecursoHumanoFacadeLocal;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.RecursoHumano;

/**
 *
 * @author erick
 */
@Named(value = "recursoHumano")
@ApplicationScoped
public class controladorRecursoHumano implements Serializable {

    private List<RecursoHumano> listaRecursos;  

@EJB
RecursoHumanoFacadeLocal recursoFacade;

    public controladorRecursoHumano() {
    }
    
    
     @PostConstruct
    public void inicio(){
      
      listaRecursos = recursoFacade.findAll();
     
      
    }

    
    
    
    
    
    
    
    
    
    public controladorRecursoHumano(List<RecursoHumano> listaRecursos, RecursoHumanoFacadeLocal recursoFacade) {
        this.listaRecursos = listaRecursos;
        this.recursoFacade = recursoFacade;
    }
    
  

    public List<RecursoHumano> getListaRecursos() {
        return listaRecursos;
    }

    public void setListaRecursos(List<RecursoHumano> listaRecursos) {
        this.listaRecursos = listaRecursos;
    }

    public RecursoHumanoFacadeLocal getRecursoFacade() {
        return recursoFacade;
    }

    public void setRecursoFacade(RecursoHumanoFacadeLocal recursoFacade) {
        this.recursoFacade = recursoFacade;
    }

    
    
    
    
    
}





