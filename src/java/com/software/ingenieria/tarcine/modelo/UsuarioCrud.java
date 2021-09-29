/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;
import java.sql.*;

public class UsuarioCrud implements Validar {

    Connection con;
    ConexionSQLServer base = new ConexionSQLServer();
    
    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    @Override
    public int validar(Usuario usu) {
        resultado = 0;
        String sql = "SELECT * FROM Registro_usuario;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, usu.getUserName());
            //ps.setString(2, usu.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).trim().equals(usu.getUserName()) && rs.getString(5).trim().equals(usu.getPassword())) {
                    resultado = 1;
                    break;
                }
                //usu.setUserName(rs.getString("Username"));
                //usu.setPassword(rs.getString("Pasword"));
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
        String sql = "SELECT * FROM Registro_usuario WHERE ID=?;";
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
        String sql = "INSERT INTO Registro_usuario (ID,Nombre,Username,Correo,Pasword) VALUES(?,?,?,?,?)";
        int iden = usu.getiD();
        while (ValidarID(iden)) {
            iden = usu.getiD();
        }
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, iden);
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
}
