package com.oocl.demo.controller;

import com.oocl.demo.model.Company;
import com.oocl.demo.model.Employee;
import com.oocl.demo.service.CompanyService;
import com.oocl.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CompanyController {

    @Autowired
    public EmployeeService employeeService;
    @Autowired
    public CompanyService companyService;
    public Company company;

    @GetMapping("/companies")
    public ArrayList<Company> getCompaniesList(){
        return companyService.getCompaniesList();
    }

    @GetMapping(path = "/companies/{companyName}")
    public Company getCompaniesByName(@PathVariable String companyName){
        return companyService.getCompaniesByName(companyName);
    }

    @GetMapping(path = "/companies/{companyName}/employees")
    public ArrayList<Employee> getCompanyEmployeesByName(@PathVariable String companyName){
        return companyService.getCompanyEmployeesByName(companyName);
    }

}
