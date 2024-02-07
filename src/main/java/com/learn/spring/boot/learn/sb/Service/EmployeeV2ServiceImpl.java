package com.learn.spring.boot.learn.sb.Service;

import com.learn.spring.boot.learn.sb.Model.Employee;
import com.learn.spring.boot.learn.sb.entity.EmployeeEntity;
import com.learn.spring.boot.learn.sb.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        if(employee.getId() == null || employee.getId().isEmpty()){
            String ID = UUID.randomUUID().toString();
            employee.setId(ID);
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<Employee> employees = employeeEntities.stream()
                .map(employeeEntity -> {
                    Employee employee  = new Employee();
                    BeanUtils.copyProperties(employeeEntity,employee);
                    return employee;
                }).collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee with id : " + id + "deleted successfulyy";
    }
}
