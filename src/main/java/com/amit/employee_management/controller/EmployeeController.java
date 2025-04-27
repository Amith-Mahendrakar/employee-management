package com.amit.employee_management.controller;

import com.amit.employee_management.entity.Employee;
import com.amit.employee_management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable Long id)
    {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee not found with id: " + id
                ));
    }
}
