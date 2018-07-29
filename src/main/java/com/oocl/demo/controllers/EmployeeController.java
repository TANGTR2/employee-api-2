package com.oocl.demo.controllers;

import com.oocl.demo.entities.Employee;
import com.oocl.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    public Employee employee;

    @GetMapping("/employees")
    public List<Employee> getEmployeesList(){
        return employeeService.getEmployeesList();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/employees/male")
    public List<Employee> getEmployeeBygender(){
        return employeeService.getEmployeeBygender();
    }

    @PostMapping(path = "/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeService.AddEmployee(employee);
    }

    @PutMapping(path = "/employees/{id}")
    public Employee putEmployeeById(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployeeById(id,employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    public  ResponseEntity deleteEmployeeById(@PathVariable Long id){
        if (employeeService.deleteEmployeeById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/employees/page")
    public List<Employee> getEmployeesByPage(@PathVariable int page,int size){
        return  employeeService.getEmployeesByPage(PageRequest.of(page, size));
    }
}
