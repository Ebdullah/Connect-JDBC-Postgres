package com.jdbcTutotial.db;

import com.jdbcTutotial.model.Employee;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class EmployeeDAO {

    // Insert employee into the database
    public boolean insertEmployee(Employee employee) {
        String query = "INSERT INTO employee_schema.employees (name, email, position, salary, join_date) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setTimestamp(5, employee.getJoinDate());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error inserting employee: " + e.getMessage());
            return false;
        }
    }

    // Update employee details
    public boolean updateEmployee(int id, Employee employee) {
        String query = "UPDATE employee_schema.employees SET name = ?, email = ?, position = ?, salary = ?, join_date = ? " +
                "WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setTimestamp(5, employee.getJoinDate());
            pstmt.setInt(6, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
            return false;
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM employee_schema.employees WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }

    // Get employee details by ID
    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM employee_schema.employees WHERE id = ?";
        Employee employee = null;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");
                Timestamp joinDate = rs.getTimestamp("join_date");

                employee = new Employee(name, email, position, salary, joinDate);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching employee: " + e.getMessage());
        }

        return employee;
    }
}
