package com.shn.dao;

import com.shn.model.Employee;
import com.shn.util.EmployeeUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class EmployeeDao {

    private Map<String, Employee> employeeMap = new HashMap<>();

    @PostConstruct
    private void loadEmployee() {
        List<Employee> employees = EmployeeUtil.getEmployees();
        employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
    }

    public boolean addEmployee(Employee employee) {
        if (!employeeMap.containsKey(employee.getId())) {
            employeeMap.put(employee.getId(), employee);
            return true;
        }
        return false;
    }

    public Employee getEmployee(String empId) {
        return employeeMap.get(empId);
    }
}
