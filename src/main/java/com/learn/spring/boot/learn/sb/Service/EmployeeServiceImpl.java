package com.learn.spring.boot.learn.sb.Service;

import com.learn.spring.boot.learn.sb.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//As this is a service layer should be anotated by service
@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getId() == null || employee.getId().isEmpty()){
            String ID = UUID.randomUUID().toString();
            employee.setId(ID);
        }
        employeeList.add(employee);
        return employee;
    }
}
