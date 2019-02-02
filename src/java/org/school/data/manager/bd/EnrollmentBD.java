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
import org.school.data.manager.pojos.Enrollment;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class EnrollmentBD {
    static public List<Enrollment> getAllEnrollments() throws Exception {
        List<Enrollment> registros = new ArrayList<Enrollment>();
        
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM enrollment");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Enrollment registro = new Enrollment();

                registro.setID(rs.getInt("ID"));
                registro.setUserID(rs.getInt("userID"));
                registro.setSubjectID(rs.getInt("subjectID"));

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

    static public Enrollment getEnrollment(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM enrollment WHERE ID = " + id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Enrollment registro = new Enrollment();

                registro.setID(rs.getInt("ID"));
                registro.setUserID(rs.getInt("userID"));
                registro.setSubjectID(rs.getInt("subjectID"));

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

    static public void addEnrollment(Enrollment registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str;
            
            if (registro.getID() != -1) {
                str = "INSERT INTO enrollment (ID, userID, subjectID) VALUES ("
                        + registro.getID() + ","
                        + registro.getUserID()+ ","
                        + registro.getSubjectID()+ ")";
            } else {
                str = "INSERT INTO enrollment (userID, subjectID) VALUES ("
                        + registro.getUserID()+ ","
                        + registro.getSubjectID()+ ")";
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

    static public void delEnrollment(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("DELETE FROM enrollment WHERE ID = " + id + "");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public void updateEnrollment(Enrollment registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str = "UPDATE enrollment SET userID = " + registro.getUserID()
                    + ", subjectID = " + registro.getSubjectID()
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