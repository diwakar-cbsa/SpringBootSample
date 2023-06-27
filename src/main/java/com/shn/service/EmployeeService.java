package com.shn.service;

import com.shn.dao.EmployeeDao;
import com.shn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public Employee getEmployee(String id) {
        return employeeDao.getEmployee(id);
    }
}
