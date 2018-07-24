package com.oocl.demo.controller;

import com.oocl.demo.model.Employee;
import com.oocl.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    public Employee employee;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployeesList(){
        return employeeService.getEmployeesList();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

//    @GetMapping(path = "/employees/{gender}")
//    public ArrayList<Employee> getEmployeeBygender(@PathVariable String gender){
//        return employeeService.getEmployeeBygender(gender);
//    }

    @GetMapping(path = "/employees/male")
    public ArrayList<Employee> getEmployeeBygender(){
        return employeeService.getEmployeeBygender();
    }

    @PostMapping(path = "/employees")
    public ArrayList<Employee> postEmployee(@RequestBody Employee employee) {
        return employeeService.postEmployee(employee);
    }

    @PutMapping(path = "/employees/{id}")
    public ArrayList<Employee> putEmployeeById(@RequestBody Employee employee){
        return employeeService.updateEmployeeById(employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    public  ArrayList<Employee> deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
}
