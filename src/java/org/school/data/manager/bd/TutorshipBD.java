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
import org.school.data.manager.pojos.Tutorship;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class TutorshipBD {
    static public List<Tutorship> getAllTutorships() throws Exception {
        List<Tutorship> registros = new ArrayList<Tutorship>();
        
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM tutorship ORDER BY name DESC");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Tutorship registro = new Tutorship();

                registro.setID(rs.getInt("ID"));
                registro.setName(rs.getString("name"));
                registro.setClassroom(rs.getString("classroom"));
                registro.setStartTime(rs.getString("startTime"));
                registro.setEndingTime(rs.getString("endingTime"));
                registro.setClassroomID(rs.getInt("classroomID"));

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

    static public Tutorship getTutorship(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM tutorship WHERE ID = " + id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Tutorship registro = new Tutorship();

                registro.setID(rs.getInt("ID"));
                registro.setName(rs.getString("name"));
                registro.setClassroom(rs.getString("classroom"));
                registro.setStartTime(rs.getString("startTime"));
                registro.setEndingTime(rs.getString("endingTime"));
                registro.setClassroomID(rs.getInt("classroomID"));

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

    static public void addTutorship(Tutorship registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str;
            
            if (registro.getID() != -1) {
                str = "INSERT INTO tutorship (ID, name, classroom, startTime, endingTime, classroomID) VALUES ("
                        + registro.getID() + ","
                        + "'" + registro.getName()+ "',"
                        + "'" + registro.getClassroom()+ "',"
                        + "'" + registro.getStartTime()+ "',"
                        + "'" + registro.getEndingTime()+ "',"
                        + registro.getClassroomID()+ ")";
            } else {
                str = "INSERT INTO tutorship (name, classroom, startTime, endingTime, classroomID) VALUES ("
                        + "'" + registro.getName()+ "',"
                        + "'" + registro.getClassroom()+ "',"
                        + "'" + registro.getStartTime()+ "',"
                        + "'" + registro.getEndingTime()+ "',"
                        + registro.getClassroomID()+ ")";
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

    static public void delTutorship(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("DELETE FROM tutorship WHERE ID = " + id + "");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public void updateTutorship(Tutorship registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str = "UPDATE tutorship SET name = '" + registro.getName()+ "'"
                    + ", classroom = '" + registro.getClassroom()+ "'"
                    + ", startTime = '" + registro.getStartTime()+ "'"
                    + ", endingTime = '" + registro.getEndingTime()+ "'"
                    + ", classroomID = " + registro.getClassroomID()
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
