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
import org.school.data.manager.pojos.Subject;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class SubjectBD {
    static public List<Subject> getAllSubjects() throws Exception {
        List<Subject> registros = new ArrayList<Subject>();
        
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM subject ORDER BY name ASC");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Subject registro = new Subject();

                registro.setID(rs.getInt("ID"));
                registro.setName(rs.getString("name"));
                registro.setTeacher(rs.getString("teacher"));
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

    static public Subject getSubject(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM subject WHERE ID = " + id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Subject registro = new Subject();

                registro.setID(rs.getInt("ID"));
                registro.setName(rs.getString("name"));
                registro.setTeacher(rs.getString("teacher"));
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

    static public void addSubject(Subject registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str;
            
            if (registro.getID() != -1) {
                str = "INSERT INTO subject (ID, name, teacher, classroom, startTime, endingTime, classroomID) VALUES ("
                        + registro.getID() + ","
                        + "'" + registro.getName()+ "',"
                        + "'" + registro.getTeacher()+ "',"
                        + "'" + registro.getClassroom()+ "',"
                        + "'" + registro.getStartTime()+ "',"
                        + "'" + registro.getEndingTime()+ "',"
                        + registro.getClassroomID()+ ")";
            } else {
                str = "INSERT INTO subject (name, teacher, classroom, startTime, endingTime, classroomID) VALUES ("
                        + "'" + registro.getName()+ "',"
                        + "'" + registro.getTeacher()+ "',"
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

    static public void delSubject(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("DELETE FROM subject WHERE ID = " + id + "");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public void updateSubject(Subject registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str = "UPDATE subject SET name = '" + registro.getName()+ "'"
                    + ", teacher = '" + registro.getTeacher()+ "'"
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