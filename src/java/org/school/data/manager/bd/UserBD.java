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
import org.school.data.manager.pojos.User;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class UserBD {
    static public List<User> getAllUsers() throws Exception {
        List<User> registros = new ArrayList<User>();
        
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM user ORDER BY dni ASC");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                User registro = new User();

                registro.setID(rs.getInt("userID"));
                registro.setNombreUsuario(rs.getString("nombreUsuario"));
                registro.setNombre(rs.getString("nombre"));
                registro.setPrimerApellido(rs.getString("primerApellido"));
                registro.setSegundoApellido(rs.getString("segundoApellido"));
                registro.setEdad(rs.getString("edad"));
                registro.setDni(rs.getString("dni"));
                registro.setGenero(rs.getInt("genero"));
                registro.setTipoDeMiembro(rs.getInt("tipoDeMiembro"));
                registro.setPassword(rs.getString("password"));

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

    static public User getUser(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM user WHERE userID = " + id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                User registro = new User();

                registro.setID(rs.getInt("userID"));
                registro.setNombreUsuario(rs.getString("nombreUsuario"));
                registro.setNombre(rs.getString("nombre"));
                registro.setPrimerApellido(rs.getString("primerApellido"));
                registro.setSegundoApellido(rs.getString("segundoApellido"));
                registro.setEdad(rs.getString("edad"));
                registro.setDni(rs.getString("dni"));
                registro.setGenero(rs.getInt("genero"));
                registro.setTipoDeMiembro(rs.getInt("tipoDeMiembro"));
                registro.setPassword(rs.getString("password"));

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

    static public void addUser(User registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str;
            
            if (registro.getID() != -1) {
                str = "INSERT INTO user (userID, nombreUsuario, nombre, primerApellido, segundoApellido, edad, dni, genero, tipoDeMiembro, password) VALUES ("
                        + registro.getID() + ","
                        + "'" + registro.getNombreUsuario()+ "',"
                        + "'" + registro.getNombre()+ "',"
                        + "'" + registro.getPrimerApellido()+ "',"
                        + "'" + registro.getSegundoApellido()+ "',"
                        + registro.getEdad()+ ","
                        + "'" + registro.getDni()+ "',"
                        + registro.getGenero()+ ","
                        + registro.getTipoDeMiembro()+ ","
                        + "'" + registro.getPassword()+ "')";
            } else {
                str = "INSERT INTO user (nombreUsuario, nombre, primerApellido, segundoApellido, edad, dni, genero, tipoDeMiembro, password) VALUES ("
                        + "'" + registro.getNombreUsuario()+ "',"
                        + "'" + registro.getNombre()+ "',"
                        + "'" + registro.getPrimerApellido()+ "',"
                        + "'" + registro.getSegundoApellido()+ "',"
                        + registro.getEdad()+ ","
                        + "'" + registro.getDni()+ "',"
                        + registro.getGenero()+ ","
                        + registro.getTipoDeMiembro()+ ","
                        + "'" + registro.getPassword()+ "')";
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

    static public void delUser(int id) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("DELETE FROM user WHERE userID = " + id + "");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    static public void updateUser(User registro) throws SQLException {
        Connection conexion = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String str = "UPDATE user SET nombreUsuario = '" + registro.getNombreUsuario()+ "'"
                    + ", nombre = '" + registro.getNombre()+ "'"
                    + ", primerApellido = '" + registro.getPrimerApellido()+ "'"
                    + ", segundoApellido = '" + registro.getSegundoApellido()+ "'"
                    + ", edad = " + registro.getEdad()
                    + ", dni = '" + registro.getDni()+ "'"
                    + ", genero = " + registro.getGenero()
                    + ", tipoDeMiembro = " + registro.getTipoDeMiembro()
                    + ", password = '" + registro.getPassword()+ "'"
                    + " WHERE userID = " + registro.getID();
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