package com.skypro.collections.Service;

import com.skypro.collections.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstname, String surname);

    Employee removeEmployee(String firstName, String surName);

    Employee searchEmployee(String firstName, String surName);

    List<Employee> searchAll();
}
