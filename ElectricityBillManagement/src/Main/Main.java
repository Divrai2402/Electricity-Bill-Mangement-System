/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import admin.AdminLogin;
import admin.AdminMenu;
import customer.CustomerLogin;
import customer.CustomerMenu;
import customer.CustomerRegister;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== ELECTRICITY BILL MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Register");
            System.out.println("3. Customer Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    CustomerRegister.register();
                    break;
                case 3:
                    customerLogin();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void adminLogin() {
        System.out.print("Enter admin username: ");
        String username = sc.nextLine();
        System.out.print("Enter admin password: ");
        String password = sc.nextLine();

        if (AdminLogin.login(username, password)) {
            AdminMenu.show();
        } else {
            System.out.println("❌ Invalid admin credentials!");
        }
    }

    private static void customerLogin() {
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int customerId = CustomerLogin.login(email, password);
        if (customerId != -1) {
            CustomerMenu.show(customerId);
        } else {
            System.out.println("❌ Invalid customer credentials!");
        }
    }
}

