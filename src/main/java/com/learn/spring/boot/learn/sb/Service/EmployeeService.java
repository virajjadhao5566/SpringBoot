package com.learn.spring.boot.learn.sb.Service;

import com.learn.spring.boot.learn.sb.Model.Employee;
import com.learn.spring.boot.learn.sb.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);

    List<Employee> getEmployeeList();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
