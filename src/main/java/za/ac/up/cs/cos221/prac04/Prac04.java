/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package za.ac.up.cs.cos221.prac04;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Thuthuka
 */
public class Prac04 {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Stuff for GUI
                TOpFOrm dawg = new TOpFOrm();
                dawg.setVisible(true);
                
                MySQL sql = new MySQL();

                //Adding Entries to StaffTable
                try ( Statement stmt = sql.conn.createStatement()) {
                    DefaultTableModel model = (DefaultTableModel) dawg.staffTable.getModel();
                    ResultSet rs = stmt.executeQuery("SELECT `first_name`, `last_name`, `address`, `address2`, `district`, `city_id` AS `city`, `postal_code`, `phone`, `store_id` AS `store`, `active` FROM u21451088_sakila.staff, u21451088_sakila.address WHERE staff.address_id = address.address_id");
                    while (rs.next()) {
                        String firstName = rs.getString("first_name"), lastName = rs.getString("last_name"), address = rs.getString("address"), address2 = rs.getString("address2"), district = rs.getString("district"), city = rs.getString("city"), postCode = rs.getString("postal_code"), phone = rs.getString("phone");
                        boolean active = rs.getBoolean("active");
                        
                        model.addRow(new Object[]{firstName, lastName, address, address2, district, city, postCode, phone, active});
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }

                //Adding Entries to FilmsTable
                try ( Statement stmt = sql.conn.createStatement()) {
                    DefaultTableModel model = (DefaultTableModel) dawg.filmTable.getModel();
                    ResultSet rs = stmt.executeQuery("SELECT DISTINCT * FROM u21451088_sakila.film, u21451088_sakila.language WHERE film.language_id = language.language_id OR film.original_language_id = language.language_id");
                    while (rs.next()) {
                        
                        model.addRow(new Object[]{rs.getString("title"), rs.getString("description"), rs.getString("release_year"), rs.getString("name"), rs.getString("original_language_id"), rs.getInt("rental_duration"), rs.getString("rental_duration"), rs.getString("length"), rs.getString("replacement_cost"), rs.getString("rating"), rs.getString("special_features")});
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        });
    }
}
