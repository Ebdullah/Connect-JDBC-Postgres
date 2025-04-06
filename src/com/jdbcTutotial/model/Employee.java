package com.jdbcTutotial.model;

import java.sql.Timestamp;

public class Employee {
    private String name;
    private String email;
    private String position;
    private double salary;
    private Timestamp joinDate;

    // Constructor
    public Employee(String name, String email, String position, double salary, Timestamp joinDate) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Timestamp getJoinDate() { return joinDate; }
    public void setJoinDate(Timestamp joinDate) { this.joinDate = joinDate; }
}
