/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Cristian Castro
 */
public class TarjetaCRUD implements ValidarT{
    Connection con;
    ConexionSQLServer base = new ConexionSQLServer();
    Tarjeta t;

    PreparedStatement ps;
    ResultSet rs;
    @Override
    public boolean validarTarjeta(int id) {
        boolean resultado = false;
        String sql = "SELECT ID FROM Tarjetas_Creadas WHERE ID=?;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            System.out.println(id);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                resultado = true;
            }
            con.close();
            ps.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        }
        return resultado;
    }
    public Tarjeta getTarjeta(int id){
        String sql = "SELECT * FROM Tarjetas_Creadas WHERE ID=?;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            //ps.setString(2, usu.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                t = new Tarjeta(rs.getInt("ID"),rs.getInt("Saldo"));
                t.setCod(rs.getString("CodTarjeta"));
            }
            con.close();
            ps.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return t;
    }
    public boolean validarCod(String cod){
        boolean existe = false;
        String sql = "SELECT * FROM Tarjetas_Creadas WHERE CodTarjeta=?;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            existe = true;
        }
        return existe;
    }
    public boolean CrearTarjeta(Tarjeta t){
        boolean registrado = false;
        String sql = "INSERT INTO Tarjetas_Creadas(ID,CodTarjeta,Saldo) VALUES(?,?,?)";
        t.generadorCodTarjeta();
        while (validarCod(t.getCod())) {
            t.generadorCodTarjeta();
        }

        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.setString(2,t.getCod());
            ps.setLong(3, t.getSaldo());
           
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
    
    public boolean recargarTarjeta(String cod,long saldo){
        boolean recarga = false;
        String sql = "UPDATE Tarjetas_Creadas SET Saldo=? WHERE CodTarjeta=?";               
        try {
            long sal = getSaldo(cod) + saldo;
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, sal);
            ps.setString(2,cod);
            int rowInsert = ps.executeUpdate();
            con.close();
            ps.close();
            rs.close();
            recarga = true;
        } catch (Exception e) {
            recarga = false;
            System.out.println("mensaje");
            e.getMessage();
        }
        return recarga;
    }
    
    public long getSaldo(String cod){
        long sald = 0;
        String sql = "SELECT * FROM Tarjetas_Creadas WHERE CodTarjeta=?;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                sald = rs.getInt("Saldo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return sald;
    }
    

    @Override
    public boolean AgregarTarjeta(Tarjeta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
