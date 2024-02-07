package com.learn.spring.boot.learn.sb.Controller;

import com.learn.spring.boot.learn.sb.Model.Employee;
import com.learn.spring.boot.learn.sb.Service.EmployeeService;
import com.learn.spring.boot.learn.sb.Service.EmployeeV2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {
//    For segregating the versions
    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;
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
