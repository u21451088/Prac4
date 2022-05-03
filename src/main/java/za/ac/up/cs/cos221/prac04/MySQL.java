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

    String proto, host, port, name, username, password;
    static Connection conn;

    public MySQL() {
        System.out.println(System.getenv("SAKILA_DB_HOST"));
        proto = System.getenv("SAKILA_DB_PROTO");
        host = System.getenv("SAKILA_DB_HOST");
        port = System.getenv("SAKILA_DB_PORT");
        name = System.getenv("SAKILA_DB_NAME");
        username = System.getenv("SAKILA_DB_USERNAME");
        password = System.getenv("SAKILA_DB_PASSWORD");
        String connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + name + "?serverTimezone=UTC";
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(connectionUrl, username, password);
            } catch (SQLException e) {
                // handle the exception
                System.out.println(e);
            }
        }
    }

}
