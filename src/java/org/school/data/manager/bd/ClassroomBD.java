/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.data.manager.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.school.data.manager.pojos.Classroom;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ClassroomBD {
    static public List<Classroom> getAllClassrooms() throws Exception {
        List<Classroom> registros = new ArrayList<Classroom>();
        
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM classroom ORDER BY classroomName ASC");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Classroom registro = new Classroom();

                registro.setID(rs.getInt("ID"));
                registro.setClassroomName(rs.getString("classroomName"));
                registro.setDetails(rs.getString("details"));
                registro.setImage(rs.getString("image"));

                registros.add(registro);
            }
            return registros;
        } catch (Exception e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public Classroom getClassroom(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM classroom WHERE classroomID = " + id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Classroom registro = new Classroom();

                registro.setID(rs.getInt("ID"));
                registro.setClassroomName(rs.getString("classroomName"));
                registro.setDetails(rs.getString("details"));
                registro.setImage(rs.getString("image"));

                return registro;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
        return null;
    }

    static public void addClassroom(Classroom registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str;
            
            if (registro.getID() != -1) {
                str = "INSERT INTO classroom (ID, classroomName, details, image) VALUES ("
                        + registro.getID() + ","
                        + "'" + registro.getClassroomName()+ "',"
                        + "'" + registro.getDetails()+ "',"
                        + "'" + registro.getImage()+ "')";
            } else {
                str = "INSERT INTO classroom (classroomName, details, image) VALUES ("
                        + "'" + registro.getClassroomName()+ "',"
                        + "'" + registro.getDetails()+ "',"
                        + "'" + registro.getImage()+ "')";
            }

            ps = conexion.prepareStatement(str);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public void delClassroom(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("DELETE FROM classroom WHERE ID = " + id + "");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public void updateClassroom(Classroom registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str = "UPDATE classroom SET classroomName = '" + registro.getClassroomName()+ "'"
                    + ", details = '" + registro.getDetails()+ "'"
                    + ", image = '" + registro.getImage()+ "'"
                    + " WHERE ID = " + registro.getID();
            ps = conexion.prepareStatement(str);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }
}