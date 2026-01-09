/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import db.DBConnection;
import java.sql.*;

public class ManageCustomer {

    public static void showAll() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM customer";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n--- Registered Customers ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("customer_id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") +
                        ", Contact: " + rs.getString("contact_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
