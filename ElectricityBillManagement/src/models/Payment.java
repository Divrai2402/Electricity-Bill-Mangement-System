/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

public class Payment {
    private int paymentId;
    private int billId;
    private Date paymentDate;
    private double amountPaid;

    public Payment() {}

    public Payment(int paymentId, int billId, Date paymentDate, double amountPaid) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
    }

    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }
}

