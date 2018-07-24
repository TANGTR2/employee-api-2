package com.oocl.demo.controller;

import com.oocl.demo.model.Employee;
import com.oocl.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
