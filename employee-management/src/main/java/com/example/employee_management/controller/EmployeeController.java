package com.example.employee_management.controller;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp) {
        return repo.save(emp);
    }
}
