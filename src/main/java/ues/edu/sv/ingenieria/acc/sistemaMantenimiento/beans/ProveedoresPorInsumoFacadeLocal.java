/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProveedoresPorInsumo;

/**
 *
 * @author erick
 */
@Local
public interface ProveedoresPorInsumoFacadeLocal {

    void create(ProveedoresPorInsumo proveedoresPorInsumo);

    void edit(ProveedoresPorInsumo proveedoresPorInsumo);

    void remove(ProveedoresPorInsumo proveedoresPorInsumo);

    ProveedoresPorInsumo find(Object id);

    List<ProveedoresPorInsumo> findAll();

    List<ProveedoresPorInsumo> findRange(int[] range);

    int count();
    
}
