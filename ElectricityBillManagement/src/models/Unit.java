/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Unit {
    private int unitId;
    private int customerId;
    private String month;
    private int year;
    private int unitsConsumed;

    public Unit() {}

    public Unit(int unitId, int customerId, String month, int year, int unitsConsumed) {
        this.unitId = unitId;
        this.customerId = customerId;
        this.month = month;
        this.year = year;
        this.unitsConsumed = unitsConsumed;
    }

    public int getUnitId() { return unitId; }
    public void setUnitId(int unitId) { this.unitId = unitId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getUnitsConsumed() { return unitsConsumed; }
    public void setUnitsConsumed(int unitsConsumed) { this.unitsConsumed = unitsConsumed; }
}

