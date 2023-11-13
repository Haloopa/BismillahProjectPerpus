/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectperpus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Septiancesare
 */
public class ConnectionDatabase {
     String url = "jdbc:mysql://localhost:3306/percobaan";
    String username = "root";
    String password = "";
    
    private static Connection koneksi;
    private static ConnectionDatabase instance;
    
    
    private void connect() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, username, password);
            
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static synchronized ConnectionDatabase getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionDatabase();
            instance.connect();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return koneksi;
    }
    
    public void closeConnection(){
        if (koneksi != null) {
            try {
                koneksi.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
