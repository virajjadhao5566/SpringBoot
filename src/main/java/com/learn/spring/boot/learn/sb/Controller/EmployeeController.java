package com.learn.spring.boot.learn.sb.Controller;

import com.learn.spring.boot.learn.sb.Model.Employee;
import com.learn.spring.boot.learn.sb.Service.EmployeeService;
import com.learn.spring.boot.learn.sb.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
//    autowired is used for dependency injection
//    Qualifier is added to add the multiple version and add the version we want with current one
    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;
//    as employee will a entered as a json body format
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployeeList();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
         return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }
}
