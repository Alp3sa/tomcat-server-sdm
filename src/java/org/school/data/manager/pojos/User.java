/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.data.manager.pojos;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class User{
    int ID;
    String nombreUsuario;
    String nombre;
    String primerApellido;
    String segundoApellido;
    String edad;
    String dni;
    int genero;
    int tipoDeMiembro;
    String password;

    public User() {
    }

    public User(int ID, String nombreUsuario, String nombre, String primerApellido, String segundoApellido, String edad, String dni, int genero, int tipoDeMiembro, String password) {
        this.ID = ID;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
        this.dni = dni;
        this.genero = genero;
        this.tipoDeMiembro = tipoDeMiembro;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getTipoDeMiembro() {
        return tipoDeMiembro;
    }

    public void setTipoDeMiembro(int tipoDeMiembro) {
        this.tipoDeMiembro = tipoDeMiembro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}