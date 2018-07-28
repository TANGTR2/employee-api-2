package com.oocl.demo.controllers;

import com.oocl.demo.entities.Company;
import com.oocl.demo.entities.Employee;
import com.oocl.demo.services.CompanyService;
import com.oocl.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public ArrayList<Company> getCompaniesByPage(@PathVariable int page,@PathVariable int pageSize){
        return  companyService.getCompaniesByPage(page,pageSize);
    }

    @PostMapping(path = "/companies")
    public ArrayList<Company> postCompany(@RequestBody Company company) {
        return companyService.postCompany(company);
    }

    @PutMapping(path = "/companies/{companyName}")
    public ArrayList<Company> putCompanyByName(@RequestBody Company company){
        return companyService.updateCompanyByName(company);
    }

    @DeleteMapping(path = "/companies/{companyName}")
    public ArrayList<Company> deleteCompanyByName(@PathVariable String companyName){
        return companyService.deleteCompanyByName(companyName);
    }

}
