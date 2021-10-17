/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioCrud implements Validar {

    Connection con;
    ConexionSQLServer base = new ConexionSQLServer();

    PreparedStatement ps;
    ResultSet rs;
    int resultado;
    private int iden;

    @Override
    public int validar(Usuario usu) {
        resultado = 0;
        String sql = "SELECT * FROM dbo.Registro_usuario;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).trim().equals(usu.getUserName()) && rs.getString(5).trim().equals(usu.getPassword())) {
                    resultado = 1;
                    break;
                }
            }
            con.close();
            ps.close();
            rs.close();
            if (resultado == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean ValidarID(int id) {
        boolean existe = false;
        String sql = "SELECT * FROM dbo.Registro_usuario WHERE ID=?;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                existe = true;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            existe = true;
        }
        return existe;
    }

    @Override
    public boolean agregar(Usuario usu) {
        boolean registrado = false;
        String sql = "INSERT INTO dbo.Registro_usuario (ID,Nombre,Username,Correo,Pasword) VALUES(?,?,?,?,?)";
        usu.setIden(usu.getiD()); 
        while (ValidarID(usu.getIden())) {
            usu.setIden(usu.getiD());
        }

        try {
            if (validarCorreo(usu.getCorreo()) || validarUserName(usu.getUserName())) {throw new Exception();}
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usu.getIden());
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getUserName());
            ps.setString(4, usu.getCorreo());
            ps.setString(5, usu.getPassword());
            int rowInsert = ps.executeUpdate();
            con.close();
            ps.close();
            rs.close();
            registrado = true;
        } catch (Exception e) {
            registrado = false;
        }
        return registrado;
    }

    public int getIden() {
        return iden;
    }

   

    public boolean validarCorreo(String correo) {
        boolean existe = false;
        String sql = "SELECT Correo FROM dbo.Registro_usuario WHERE Correo=?";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            while (rs.next()) {
                existe = true;
                break;
            }
        } catch (Exception e) {
        }
        return existe;
    }
    
    public void actualizarDatos(Usuario usu){
        String sql = "UPDATE dbo.Registro_usuario SET Nombre=?, Username=?, Correo=?, Pasword=? WHERE ID=?";
        try {
            System.out.println("id : "+usu.getIden());
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getUserName());
            ps.setString(3, usu.getCorreo());
            ps.setString(4, usu.getPassword());
            System.out.println("id : "+usu.getIden());
            ps.setInt(5, usu.getIden());
            int rowInsert = ps.executeUpdate();
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("mensaje");
            e.getMessage();
        }
    }

    public boolean validarUserName(String user) {
        boolean existe = false;
        String sql = "SELECT Username FROM dbo.Registro_usuario WHERE Username=?";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                existe = true;
                break;
            }
        } catch (Exception e) {
        }
        return existe;
    }
    
    public String getCorreo(String user){
        String correo = "";
        String sql = "SELECT Correo FROM dbo.Registro_usuario WHERE Username=?";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                correo = rs.getString("Correo");
                break;
            }
        } catch (Exception e) {
        }
        return correo;
    }
    public String getNombreC(String user){
        String nombre = "";
        String sql = "SELECT Nombre FROM dbo.Registro_usuario WHERE Username=?";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("Nombre");
                break;
            }
        } catch (Exception e) {
        }
        return nombre;
    }
    public int getID(String user){
        int id = 0;
        String sql = "SELECT ID FROM dbo.Registro_usuario WHERE Username=?";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                break;
            }
        } catch (Exception e) {
        }
        return id;
    }
    public Usuario getUsuario(int id){
        Usuario usu = null;
        String sql = "SELECT * FROM dbo.Registro_usuario WHERE ID=?";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usu = new Usuario(rs.getString("Nombre"), rs.getString("Username"), rs.getString("Correo"), rs.getString("Pasword"));
            }
        } catch (Exception e) {
        }
        return usu;
    }
}
