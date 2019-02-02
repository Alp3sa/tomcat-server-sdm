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
import org.school.data.manager.bd.EnrollmentBD;
import org.school.data.manager.pojos.Enrollment;

/**
 * REST Web Service
 *
 * @author Alfonso Pérez Santana
 */
@Path("enrollment")
public class EnrollmentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public EnrollmentResource() {
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
    public Response getAllEnrollments() {
        try {
            List<Enrollment> registros = EnrollmentBD.getAllEnrollments();
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha consultado - getAllEnrollments");
            String json = new Gson().toJson(registros);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception ex) {
            //ex.printStackTrace();
            return Response.status(Response.Status.SEE_OTHER).entity("No se pudo Consultar los enrollments ").build();
        }
    }

    // Añadir Registro. 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEnrollment(Enrollment registro) {
        try {
            EnrollmentBD.addEnrollment(registro);
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha añadido - addEnrollment " + registro.getID());
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
    public Response updateEnrollment(Enrollment registro, @PathParam("id") int id) {
        System.out.println("Llegó a la actualización");
        try {
            EnrollmentBD.updateEnrollment(registro);
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha actualizado - updateEnrollment " + registro.getID());
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
    public Response delEnrollment(@PathParam("id") int id) {

        try {
            EnrollmentBD.delEnrollment(id);
            Date fecha = new Date();
            System.out.println(fecha.toString() + ": Se ha borrado - delEnrollment " + id);
            String json = "{ \"id\": \"" + id + "\" }";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Response.status(Response.Status.SEE_OTHER).entity("No se pudo Borrar Registro: " + id).build();
        }
    }
}
