/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import db.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class MakePayment {

    public static void pay(int customerId) {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DBConnection.getConnection()) {
            String unpaidQuery = "SELECT * FROM bill WHERE customer_id = ? AND status = 'Unpaid'";
            PreparedStatement pst = conn.prepareStatement(unpaidQuery);
            pst.setInt(1, customerId);
            ResultSet rs = pst.executeQuery();

            boolean hasUnpaid = false;

            while (rs.next()) {
                hasUnpaid = true;
                int billId = rs.getInt("bill_id");
                double amount = rs.getDouble("amount");
                System.out.println("Unpaid Bill ID: " + billId + ", Amount: ₹" + amount);
                System.out.print("Pay this bill? (yes/no): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    // Insert into payment table
                    String payQuery = "INSERT INTO payment (bill_id, customer_id, amount) VALUES (?, ?, ?)";
                    PreparedStatement payStmt = conn.prepareStatement(payQuery);
                    payStmt.setInt(1, billId);
                    payStmt.setInt(2, customerId);
                    payStmt.setDouble(3, amount);
                    payStmt.executeUpdate();

                    // Update bill status
                    String updateQuery = "UPDATE bill SET status = 'Paid' WHERE bill_id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                    updateStmt.setInt(1, billId);
                    updateStmt.executeUpdate();

                    System.out.println("✅ Payment successful for Bill ID: " + billId);
                }
            }

            if (!hasUnpaid) {
                System.out.println("🎉 No unpaid bills found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
