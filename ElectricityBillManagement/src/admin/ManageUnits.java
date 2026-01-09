/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import db.DBConnection;
import java.sql.*;

public class ManageUnits {
    public static void addUnits(int customerId, String month, int year, int units) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO units (customer_id, month, year, units_consumed) VALUES (?, ?, ?, ?)");
            ps.setInt(1, customerId);
            ps.setString(2, month);
            ps.setInt(3, year);
            ps.setInt(4, units);
            ps.executeUpdate();
            System.out.println("Units Added.");
        } catch (Exception e) {
            System.out.println("Add Units Error: " + e.getMessage());
        }
    }
}
