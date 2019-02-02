/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.data.manager.rest;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.school.data.manager.bd.SubjectBD;
import org.school.data.manager.pojos.Subject;

/**
 * REST Web Service
 *
 * @author Alfonso Pérez Santana
 */
@Path("subject")
public class SubjectResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public SubjectResource() {
    }

    /**
     * Retrieves representation of an instance of school-data-manager.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("prueba")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPrueba() {
        Date fecha = new Date();
        System.out.println(fecha.toString() + ": Prueba");

        return "Funciona!!!!! ";
    }

    // Devuelve todos los Registros
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSubjects() {
        try {
            List<Subject> registros = SubjectBD.getAllSubjects();
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha consultado - getAllSubjects");
            String json = new Gson().toJson(registros);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception ex) {
            //ex.printStackTrace();
            return Response.status(Response.Status.SEE_OTHER).entity("No se pudo Consultar los subjects ").build();
        }
    }

    // Añadir Registro. 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSubject(Subject registro) {
        try {
            SubjectBD.addSubject(registro);
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha añadido - addSubject " + registro.getID());
            String json = "{ \"id\": \"" + String.valueOf(registro.getID()) + "\" }";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Response.status(Response.Status.SEE_OTHER).entity("No se pudo Insertar Registro: " + registro.getID()).build();
        }
    }

    // Actualizar un registro. 
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSubject(Subject registro, @PathParam("id") int id) {
        System.out.println("Llegó a la actualización");
        try {
            SubjectBD.updateSubject(registro);
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha actualizado - updateSubject " + registro.getID());
            String json = "{ \"id\": \"" + String.valueOf(registro.getID()) + "\" }";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Response.status(Response.Status.SEE_OTHER).entity("No se pudo Actualizar Registro: " + registro.getID()).build();
        }
    }

    // Borrar un registro. 
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delSubject(@PathParam("id") int id) {

        try {
            SubjectBD.delSubject(id);
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha borrado - delSubject " + id);
            String json = "{ \"id\": \"" + id + "\" }";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Response.status(Response.Status.SEE_OTHER).entity("No se pudo Borrar Registro: " + id).build();
        }
    }
}
