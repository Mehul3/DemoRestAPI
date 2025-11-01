package com.example.employee_management.service;



import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired private EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll(); }
    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow(); }
    public Employee create(Employee e) { return repo.save(e); }
    public Employee update(Long id, Employee e) {
        Employee ex = repo.findById(id).orElseThrow();
        ex.setName(e.getName());
        ex.setEmail(e.getEmail());
        ex.setRole(e.getRole());
        return repo.save(ex);
    }
    public void delete(Long id) { repo.deleteById(id); }
}

