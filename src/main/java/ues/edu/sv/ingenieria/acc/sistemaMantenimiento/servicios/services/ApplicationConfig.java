

package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author erick
 */
@javax.ws.rs.ApplicationPath("servicios")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.BitacoraDeFallasFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.CorsFilter.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.EquipoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.EstadoOrdenTrabajoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.FallaFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.MaterialesInsumosFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.OrdenCompraFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.OrdenTrabajoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.PartesFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.PartesPorEquipoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.ProcedimientoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.ProcedimientoPorEquipoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.ProgramacionFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.ProveedoresFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.ProveedoresPorInsumoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.RecursoHumanoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.TipoFallaFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.TipoMantenimientoFacadeREST.class);
        resources.add(ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services.TipoProgramacionFacadeREST.class);
    }
    
}
