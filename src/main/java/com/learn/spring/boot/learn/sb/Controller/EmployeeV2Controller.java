package com.learn.spring.boot.learn.sb.Controller;

import com.learn.spring.boot.learn.sb.Model.Employee;
import com.learn.spring.boot.learn.sb.Service.EmployeeService;
import com.learn.spring.boot.learn.sb.Service.EmployeeV2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {
    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
}
