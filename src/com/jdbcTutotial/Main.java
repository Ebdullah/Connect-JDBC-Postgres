package com.jdbcTutotial;

import com.jdbcTutotial.model.Employee;
import com.jdbcTutotial.db.EmployeeDAO;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();


        // Insert new employee
        Employee newEmployee = new Employee("Sandhu", "sandhu.dev@example.com", "Devops Engineer", 95000, new Timestamp(System.currentTimeMillis()));
        boolean insertSuccess = employeeDAO.insertEmployee(newEmployee);
        System.out.println("Employee inserted: " + insertSuccess);

        // Fetch employee by ID
        Employee fetchedEmployee = employeeDAO.getEmployeeById(2);
        if (fetchedEmployee != null) {
            System.out.println("Employee Name: " + fetchedEmployee.getName());
            System.out.println("Employee Email: " + fetchedEmployee.getEmail());
            System.out.println("Employee Role: " + fetchedEmployee.getPosition());
            System.out.println("Employee Salary: " + fetchedEmployee.getSalary());
        } else {
            System.out.println("Employee not found.");
        }
    }
}
