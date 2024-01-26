package org.work.springbootwork.service;

import org.work.springbootwork.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
}
