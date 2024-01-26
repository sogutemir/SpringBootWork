package org.work.springbootwork.controller;

import org.springframework.web.bind.annotation.*;
import org.work.springbootwork.model.Employee;
import org.work.springbootwork.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/GetAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/GetEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/CreateEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/UpdateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/DeleteEmployee/{id}")
    public Employee deleteEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
}
