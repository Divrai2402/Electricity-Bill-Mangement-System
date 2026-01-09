/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class GenerateBill {

    public static void generate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();
        double ratePerUnit = 5.50; // You can fetch this from `units` table dynamically
        double amount = units * ratePerUnit;

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO bill (customer_id, units_consumed, amount, status) VALUES (?, ?, ?, 'Unpaid')";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, customerId);
            pst.setInt(2, units);
            pst.setDouble(3, amount);
            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Bill generated successfully. Amount: ₹" + amount);
            } else {
                System.out.println("❌ Failed to generate bill.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

