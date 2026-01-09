/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import java.util.Scanner;

public class AdminMenu {

    static Scanner sc = new Scanner(System.in);

    public static void show() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Generate Bill");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Units");
            System.out.println("4. Back to Main Dashboard");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    GenerateBill.generate();
                    break;
                case 2:
                    ManageCustomer.showAll();
                    break;
                case 3:
                    System.out.println("⚙️ Manage Units functionality not implemented yet.");
                    // You can create a ManageUnits class and implement it later
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}

