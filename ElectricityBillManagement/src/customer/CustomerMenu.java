/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer;

import java.util.Scanner;

public class CustomerMenu {

    static Scanner sc = new Scanner(System.in);

    public static void show(int customerId) {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== CUSTOMER MENU ===");
            System.out.println("1. View Bill");
            System.out.println("2. Make Payment");
            System.out.println("3. Payment History");
            System.out.println("4. Back to Main Dashboard");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    ViewBill.show(customerId);
                    break;
                case 2:
                    MakePayment.pay(customerId);
                    break;
                case 3:
                    PaymentHistory.show(customerId);
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

