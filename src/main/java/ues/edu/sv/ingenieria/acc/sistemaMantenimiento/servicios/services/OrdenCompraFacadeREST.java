/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.servicios.services;

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
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompra;
import ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompraPK;

/**
 *
 * @author erick
 */
@Stateless
@Path("ordencompra")
public class OrdenCompraFacadeREST extends AbstractFacade<OrdenCompra> {

    @PersistenceContext(unitName = "com.mycompany_sistemaMantenimiento_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private OrdenCompraPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idOrdenCompra=idOrdenCompraValue;idProveedor=idProveedorValue;idMaterialInsumo=idMaterialInsumoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompraPK key = new ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompraPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idOrdenCompra = map.get("idOrdenCompra");
        if (idOrdenCompra != null && !idOrdenCompra.isEmpty()) {
            key.setIdOrdenCompra(new java.lang.Integer(idOrdenCompra.get(0)));
        }
        java.util.List<String> idProveedor = map.get("idProveedor");
        if (idProveedor != null && !idProveedor.isEmpty()) {
            key.setIdProveedor(new java.lang.Integer(idProveedor.get(0)));
        }
        java.util.List<String> idMaterialInsumo = map.get("idMaterialInsumo");
        if (idMaterialInsumo != null && !idMaterialInsumo.isEmpty()) {
            key.setIdMaterialInsumo(new java.lang.Integer(idMaterialInsumo.get(0)));
        }
        return key;
    }

    public OrdenCompraFacadeREST() {
        super(OrdenCompra.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrdenCompra entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") PathSegment id, OrdenCompra entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompraPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrdenCompra find(@PathParam("id") PathSegment id) {
        ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.OrdenCompraPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenCompra> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenCompra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
