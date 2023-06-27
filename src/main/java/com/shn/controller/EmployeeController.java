package com.shn.controller;

import com.shn.exceptions.EmployeeException;
import com.shn.model.Employee;
import com.shn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PutMapping("/save")
    public void getEmployee(@RequestBody Employee employee) throws EmployeeException {
        try {
            employeeService.addEmployee(employee);
        } catch (Exception e) {
            throw new EmployeeException("Customer Error");
        }
    }

    @GetMapping("/details/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }
}
