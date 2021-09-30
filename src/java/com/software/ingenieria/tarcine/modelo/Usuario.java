/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

/**
 *
 * @author Cristian Castro
 */
public class Usuario {

    public int iD;
    private int idem;
    private String nombre, userName, correo, password;

    public Usuario() {
    }

    public Usuario(String nombre, String userName, String correo, String password) {
        this.nombre = nombre;
        this.userName = userName;
        this.correo = correo;
        this.password = password;
    }

    public int getiD() {
        return (int) Math.floor(Math.random() * (3000 - 1000 + 1) + 1000);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIden() {
        return this.idem;
    }

    public void setIden(int iden) {
        this.idem = iden;
    }
    
}
