/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import db.DBConnection;
import java.sql.*;

public class PaymentHistory {

    public static void show(int customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM payment WHERE customer_id = ? ORDER BY payment_id DESC";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, customerId);
            ResultSet rs = pst.executeQuery();

            System.out.println("\n--- Payment History ---");
            while (rs.next()) {
                System.out.println("Payment ID: " + rs.getInt("payment_id") +
                        ", Bill ID: " + rs.getInt("bill_id") +
                        ", Amount: ₹" + rs.getDouble("amount") +
                        ", Date: " + rs.getTimestamp("payment_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

