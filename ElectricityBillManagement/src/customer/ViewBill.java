/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import db.DBConnection;
import java.sql.*;

public class ViewBill {

    public static void show(int customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM bill WHERE customer_id = ? ORDER BY bill_id DESC";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, customerId);
            ResultSet rs = pst.executeQuery();

            System.out.println("\n--- Your Bills ---");
            while (rs.next()) {
                System.out.println("Bill ID: " + rs.getInt("bill_id") +
                        ", Units: " + rs.getInt("units_consumed") +
                        ", Amount: ₹" + rs.getDouble("amount") +
                        ", Status: " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

