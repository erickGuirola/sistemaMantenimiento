
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services;

import java.util.List;
import javax.ejb.EJB;
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
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.beans.OrdenTrabajoFacadeLocal;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenTrabajo;

/**
 *
 * @author erick
 */
@Stateless
@Path("ordentrabajo")
public class OrdenTrabajoFacadeREST extends AbstractFacade<OrdenTrabajo> {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public OrdenTrabajoFacadeREST() {
        super(OrdenTrabajo.class);
    }
    
    //Inyectando Un recurso EJB
    @Inject
    OrdenTrabajoFacadeLocal facadeLocalOrden ;

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrdenTrabajo entity) {
        super.create(entity);
        
    }
    

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, OrdenTrabajo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    
    @GET
    @Path("{estado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenTrabajo> findByEstado(@PathParam("estado") Integer estado) {
        return facadeLocalOrden.findByEstado(estado);
    }
    
    @GET
    @Path("historial")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenTrabajo> findByHistorial() {
        System.out.println("Enviado desde Historial Rest");
        return facadeLocalOrden.findByHistorial();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenTrabajo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    
    
    @GET
    @Path("ordenes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenTrabajo> orden(){
        
        return facadeLocalOrden.findAll();
    }
    
    @GET
    @Path("ordenes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrdenTrabajo find(@PathParam("id") Integer id) {
        return super.find(id);
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
