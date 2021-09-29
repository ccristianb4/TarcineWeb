/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

import java.sql.*;


public class ConexionSQLServer {

    Connection con;

    public Connection getConnection() {
        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "database=Tarcine;" + "user=sa;" + "password=123456;" + "loginTimeout=40;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
