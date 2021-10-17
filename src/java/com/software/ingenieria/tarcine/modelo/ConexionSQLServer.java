/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

import java.sql.*;


public class ConexionSQLServer {

    Connection con;
    //com.microsoft.sqlserver.jdbc.SQLServerDriver
    //"jdbc:sqlserver://localhost:1433;"
                    //+ "database=Tarcine;" + "user=sa;" + "password=123456;" + "loginTimeout=40;"
    public Connection getConnection() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = DriverManager.getConnection("jdbc:postgresql://node5039-tarcine.sp.skdrive.net:5432/postgres","webadmin","7ZMLOtyJcw");
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
// con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Tarcine","postgres","123456");
//con = DriverManager.getConnection("jdbc:postgresql://node4820-env-8494011.sp.skdrive.net:5432/postgres","webadmin","NQTuA5hoBj");