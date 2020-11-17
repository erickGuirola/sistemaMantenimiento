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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans.RecursoHumanoFacadeLocal;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.RecursoHumano;

/**
 *
 * @author erick
 */

@Named
@ViewScoped
public class controladorRecursoHumano implements Serializable {

   
 @EJB
 private RecursoHumanoFacadeLocal recursoFacade;

 private List<RecursoHumano> listaRecursos;  
 
 //CONSTRUCTORES 

 public controladorRecursoHumano(List<RecursoHumano> listaRecursos, RecursoHumanoFacadeLocal recursoFacade) {
        this.listaRecursos = listaRecursos;
        this.recursoFacade = recursoFacade;
    }

    public controladorRecursoHumano() {
        
        
    }
    
 
   @PostConstruct
   public void inicio(){
      
    }
    
   
    public void generarListas(){
        if(this.listaRecursos != null ||this.listaRecursos.isEmpty()){
            try {
                 if(this.recursoFacade != null){
                     listaRecursos = recursoFacade.findAll();
                 }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
    
    
    
  

    
     //GETTERS Y SETTES
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





