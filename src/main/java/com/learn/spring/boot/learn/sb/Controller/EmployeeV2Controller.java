package com.learn.spring.boot.learn.sb.Controller;

import com.learn.spring.boot.learn.sb.Model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees/v2")
public class EmployeeV2Controller {
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employee;
    }
}
