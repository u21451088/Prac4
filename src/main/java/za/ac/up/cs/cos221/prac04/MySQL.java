/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.up.cs.cos221.prac04;

import java.sql.*;

/**
 *
 * @author Thuthuka
 */
public class MySQL {

    static Connection conn;

    public MySQL() {
        String connectionUrl = "jdbc:mysql://localhost:3306/u21451088_sakila?serverTimezone=UTC";
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(connectionUrl, "root", "#1Poopoo");
            } catch (SQLException e) {
                // handle the exception
                System.out.println(e);
            }
        }
    }

}
