/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CustomerRegister {

    public static void register() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== CUSTOMER REGISTRATION ===");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Contact No: ");
        String contactNo = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO customer (name, email, password, address, contact_no) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, address);
            pst.setString(5, contactNo);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Registration successful! Please login now.");
            } else {
                System.out.println("❌ Registration failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

