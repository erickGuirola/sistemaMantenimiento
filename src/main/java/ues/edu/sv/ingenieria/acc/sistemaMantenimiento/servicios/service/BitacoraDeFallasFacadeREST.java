/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.service;

import java.util.List;
import javax.ejb.Stateless;
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
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallas;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallasPK;

/**
 *
 * @author erick
 */
@Stateless
@Path("bitacoradefallas")
public class BitacoraDeFallasFacadeREST extends AbstractFacade<BitacoraDeFallas> {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private BitacoraDeFallasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idEquipo=idEquipoValue;idFalla=idFallaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallasPK key = new ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallasPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idEquipo = map.get("idEquipo");
        if (idEquipo != null && !idEquipo.isEmpty()) {
            key.setIdEquipo(new java.lang.Integer(idEquipo.get(0)));
        }
        java.util.List<String> idFalla = map.get("idFalla");
        if (idFalla != null && !idFalla.isEmpty()) {
            key.setIdFalla(new java.lang.Integer(idFalla.get(0)));
        }
        return key;
    }

    public BitacoraDeFallasFacadeREST() {
        super(BitacoraDeFallas.class);
    }

    @POST
    @Override
    @Consumes( MediaType.APPLICATION_JSON)
    public void create(BitacoraDeFallas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") PathSegment id, BitacoraDeFallas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallasPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public BitacoraDeFallas find(@PathParam("id") PathSegment id) {
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.BitacoraDeFallasPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<BitacoraDeFallas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BitacoraDeFallas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
