/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Castro
 */
public class PeliculaCRUD implements ValidarP{
    Connection con;
    ConexionSQLServer base = new ConexionSQLServer();
    Tarjeta t;

    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List getNombres() {
        List<String> nombres = new ArrayList<>();
        String sql = "SELECT Nombre FROM dbo.Peliculas;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                nombres.add(rs.getString("Nombre"));
            }
            con.close();
            ps.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombres;
    }
    public Pelicula getPelicula(String nombre){
        Pelicula pelicula = null;
        String sql = "SELECT * FROM dbo.Peliculas WHERE Nombre=?;";
        try {
            con = base.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                pelicula = new Pelicula(rs.getInt("CodPelicula"), rs.getString("Nombre"), rs.getString("Duracion"), rs.getString("Genero"),rs.getString("Clasificacion"), rs.getString("Foto"));
            }
            con.close();
            ps.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pelicula;
    }
    
}
