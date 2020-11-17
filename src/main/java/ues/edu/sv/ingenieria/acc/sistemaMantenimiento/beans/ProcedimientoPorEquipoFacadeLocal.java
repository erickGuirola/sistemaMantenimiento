/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipo;

/**
 *
 * @author erick
 */
@Local
public interface ProcedimientoPorEquipoFacadeLocal  extends AbstractFacadeInterface<ProcedimientoPorEquipo>{

 public List<ProcedimientoPorEquipo> findByProcedimientos();
    
}
