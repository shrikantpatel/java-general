package com.shri.general.java8;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String city;
    double salary;
    String position;

    Employee(String name, String city, double salary, String position) {
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.position = position;
    }
}

class Department {
    String name;
    List<Employee> employees;

    Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}

public class StreamChallenge {
    public static void main(String[] args) {
        List<Department> departments = Arrays.asList(
                new Department("Engineering", Arrays.asList(
                        new Employee("Alice", "New York", 95000, "Developer"),
                        new Employee("Bob", "London", 80000, "Developer")
                )),
                new Department("Design", Arrays.asList(
                        new Employee("Charlie", "New York", 70000, "Designer"),
                        new Employee("David", "London", 75000, "Designer")
                )),
                new Department("Marketing", Arrays.asList(
                        new Employee("Eve", "San Francisco", 85000, "Manager"),
                        new Employee("Frank", "New York", 110000, "Manager")
                ))
        );

        // TODO 1: Get a unique list of all Cities where employees are based.
        // Hint: Use flatMap and distinct.
        List<String> uniqueCities = departments.stream().flatMap(department -> department.employees.stream()).map(employee -> employee.city).collect(Collectors.toList());

        // TODO 2: Find the Employee with the highest salary across the whole company.
        // Hint: Use flatMap and max with a Comparator.
        Optional<Employee> highestPaid = null;

        // TODO 3: Group employees by their Position.
        // Hint: Use Collectors.groupingBy.
        Map<String, List<Employee>> employeesByPosition = null;

        // TODO 4: Calculate the total payroll (sum of all salaries) for the "New York" office only.
        // Hint: Filter employees by city first, then mapToDouble and sum.
        double nyPayroll = 0.0;

        // --- Print Results ---
        System.out.println("Unique Cities: " + uniqueCities);
        highestPaid.ifPresent(e -> System.out.println("Highest Paid: " + e.name));
        System.out.println("Positions: " + employeesByPosition.keySet());
        System.out.println("NY Total Payroll: " + nyPayroll);
    }
}