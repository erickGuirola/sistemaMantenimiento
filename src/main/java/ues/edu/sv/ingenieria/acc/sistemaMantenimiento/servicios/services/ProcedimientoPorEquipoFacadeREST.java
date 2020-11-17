
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans.ProcedimientoPorEquipoFacadeLocal;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipo;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipoPK;

/**
 *
 * @author erick
 */
@Stateless
@Path("procedimientoporequipo")
public class ProcedimientoPorEquipoFacadeREST extends AbstractFacade<ProcedimientoPorEquipo> {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    
    @Inject
    private ProcedimientoPorEquipoFacadeLocal procedimientoPorEquipoFacade;

    private ProcedimientoPorEquipoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idProcedimiento=idProcedimientoValue;idEquipo=idEquipoValue;idMaterialInsumo=idMaterialInsumoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipoPK key = new ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idProcedimiento = map.get("idProcedimiento");
        if (idProcedimiento != null && !idProcedimiento.isEmpty()) {
            key.setIdProcedimiento(new java.lang.Integer(idProcedimiento.get(0)));
        }
        java.util.List<String> idEquipo = map.get("idEquipo");
        if (idEquipo != null && !idEquipo.isEmpty()) {
            key.setIdEquipo(new java.lang.Integer(idEquipo.get(0)));
        }
        java.util.List<String> idMaterialInsumo = map.get("idMaterialInsumo");
        if (idMaterialInsumo != null && !idMaterialInsumo.isEmpty()) {
            key.setIdMaterialInsumo(new java.lang.Integer(idMaterialInsumo.get(0)));
        }
        return key;
    }

    public ProcedimientoPorEquipoFacadeREST() {
        super(ProcedimientoPorEquipo.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ProcedimientoPorEquipo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") PathSegment id, ProcedimientoPorEquipo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.ProcedimientoPorEquipoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("procedimientos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcedimientoPorEquipo> findByProcedimientos() {
        System.out.println("Enviado desde Procedimiento Rest");
      
       return  procedimientoPorEquipoFacade.findByProcedimientos();
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcedimientoPorEquipo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcedimientoPorEquipo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
