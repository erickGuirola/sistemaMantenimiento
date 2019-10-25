/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author erick
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.BitacoraDeFallasFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.EquipoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.EstadoOrdenTrabajoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.FallaFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.MaterialesInsumosFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.OrdenCompraFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.OrdenTrabajoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.PartesFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.PartesPorEquipoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.ProcedimientoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.ProcedimientoPorEquipoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.ProgramacionFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.ProveedoresFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.ProveedoresPorInsumoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.RecursoHumanoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.TipoFallaFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.TipoMantenimientoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service.TipoProgramacionFacadeREST.class);
    }
    
}
