/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectperpus;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class ProjectPerpus {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        ConnectionDatabase connecttion = ConnectionDatabase.getInstance();
        Connection connect = connecttion.getConnection();
        
        System.out.println("Koneksi Berhasil");
        
        
    }
}
