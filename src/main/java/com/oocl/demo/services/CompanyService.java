package com.oocl.demo.services;

import com.oocl.demo.entities.Company;
import com.oocl.demo.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyService {
    ArrayList<Employee> employeeslist1 = new ArrayList<>();
    ArrayList<Employee> employeeslist2 = new ArrayList<>();
    {
        Employee employee1 = new Employee("alibaba1",20,"male",6000);
        Employee employee2 = new Employee("alibaba2",19,"female",7000);
        employeeslist1.add(employee1);employeeslist1.add(employee2);
    }
    {
        Employee employee1 = new Employee("tengxun1",20,"female",6000);
        Employee employee2 = new Employee("tengxun2",19,"female",7000);
        employeeslist2.add(employee1);employeeslist2.add(employee2);
    }

    private ArrayList<Company> companieslist = new ArrayList<>();
    {
        Company company1 = new Company("alibaba",2,this.employeeslist1);
        Company company2 = new Company("tengxun",2,this.employeeslist2);
        companieslist.add(company1);
        companieslist.add(company2);
    }

    public ArrayList<Company> getCompaniesList() {
        return companieslist;
    }

    public Company getCompaniesByName(String companyName) {
        for(Company company:companieslist){
            if(company.getCompanyName().equals(companyName)){
                return company;
            }
        }
        return null;
    }

    public ArrayList<Employee> getCompanyEmployeesByName(String companyName) {
        for(Company company:companieslist){
            if(company.getCompanyName().equals(companyName)){
                return company.getEmployeesList();
            }
        }
        return null;
    }

    public ArrayList<Company> getCompaniesByPage(int page, int pageSize) {
        ArrayList<Company> dispacth = new ArrayList<>();
        int start = (page-1)*pageSize;
        int end = (start + pageSize) > companieslist.size() ? companieslist.size() : (start+pageSize);
        for(int i=start;i<end;i++){
            dispacth.add(companieslist.get(i));
        }
        return dispacth;
    }

    public ArrayList<Company> postCompany(Company company) {
        companieslist.add(company);
        return companieslist;
    }

    public ArrayList<Company> updateCompanyByName(Company company) {
        for(Company e:companieslist){
            if(e.getCompanyName().equals(company.getCompanyName())){
                e.setCompanyName(company.getCompanyName());
                e.setEmployeesNumber(company.getEmployeesNumber());
                e.setEmployeesList(company.getEmployeesList());
            }
        }
        return companieslist;
    }

    public ArrayList<Company> deleteCompanyByName(String companyName) {
        for(Company e:companieslist){
            if(e.getCompanyName().equals(companyName)){
                companieslist.remove(e);
            }
        }
        return companieslist;
    }
}
