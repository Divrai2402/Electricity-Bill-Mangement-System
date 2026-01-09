/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String contactNo;

    // Constructors
    public Customer() {}

    public Customer(int customerId, String name, String email, String password, String address, String contactNo) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
    }

    // Getters and Setters
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
}

