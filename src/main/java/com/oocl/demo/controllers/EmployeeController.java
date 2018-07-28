package com.oocl.demo.controllers;

import com.oocl.demo.entities.Employee;
import com.oocl.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping(path = "/employees/male")
//    public ArrayList<Employee> getEmployeeBygender(){
//        return employeeService.getEmployeeBygender();
//    }
//
//    @PostMapping(path = "/employees")
//    public ArrayList<Employee> postEmployee(@RequestBody Employee employee) {
//        return employeeService.postEmployee(employee);
//    }
//
//    @PutMapping(path = "/employees/{id}")
//    public ArrayList<Employee> putEmployeeById(@RequestBody Employee employee){
//        return employeeService.updateEmployeeById(employee);
//    }
//
//    @DeleteMapping(path = "/employees/{id}")
//    public  ArrayList<Employee> deleteEmployeeById(@PathVariable int id){
//        return employeeService.deleteEmployeeById(id);
//    }
//
//    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
//    public ArrayList<Employee> getEmployeesByPage(@PathVariable int page,@PathVariable int pageSize){
//        return  employeeService.getEmployeesByPage(page,pageSize);
//    }
}
