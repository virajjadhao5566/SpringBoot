package com.learn.spring.boot.learn.sb.Service;

import com.learn.spring.boot.learn.sb.Model.Employee;
import com.learn.spring.boot.learn.sb.entity.EmployeeEntity;
import com.learn.spring.boot.learn.sb.error.EmployeeNotFoundException;
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

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
//        int n = employeeList.size();
//        for(int i = 0;i<n;i++){
//            if(id.equals(employeeList.get(i).getId())) return employeeList.get(i);
//        }
//        return null;
        return employeeList.stream()
                .filter(employee -> employee.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(()->new EmployeeNotFoundException("" +
                        "Employee not found with Id :"+id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employeeList.stream()
                .filter(e->e.getId().equalsIgnoreCase(id))
                .findFirst().get();
        employeeList.remove(employee);
        return "Employee with id : " + id + "deleted successfulyy";
    }


}
