package com.skypro.collections.Service;

import com.skypro.collections.Employee;
import com.skypro.collections.exception.EmployeeAlreadyAddedException;
import com.skypro.collections.exception.EmployeeNotFoundException;
import com.skypro.collections.exception.EmployeeStorageFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private static final int EMPLOYEE_MAX = 9;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String surName) {
        if (employees.size() == EMPLOYEE_MAX) {
            throw new EmployeeStorageFullException("Превышен лимит количества сотрудников в фирме");
        }
        Employee employee = new Employee(firstName, surName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String surName) {
        Employee employee = new Employee(firstName, surName);
        if (!employees.contains(employees)) {
            throw new EmployeeNotFoundException("Сотрудника не существует");
        }
        return employee;
    }

    @Override
    public Employee searchEmployee(String firstName, String surName) {
        Employee employee = new Employee(firstName, surName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return employee;
    }
    @Override
    public List<Employee> searchAll(){
        return employees;
    }
}


