package com.oocl.demo.controller;

import com.oocl.demo.model.Company;
import com.oocl.demo.service.CompanyService;
import com.oocl.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        System.out.println(324324 );
        return companyService.getCompaniesList();
    }
}
