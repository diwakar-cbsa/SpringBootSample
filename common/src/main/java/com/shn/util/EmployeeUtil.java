package com.shn.util;

import com.shn.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtil {
    public static Employee getEmployee() {
        return Employee.builder().id("1").name("diwakar").addresses(AddressUtil.getDiwakarAddresses()).build();
    }

    public static List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(getEmployee());
        employeeList.add(Employee.builder().id("2").name("monu").addresses(AddressUtil.getMonuAddresses()).build());
        return employeeList;
    }
}
