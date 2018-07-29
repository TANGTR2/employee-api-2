package com.oocl.demo.services;

import com.oocl.demo.entities.Company;
import com.oocl.demo.entities.Employee;
import com.oocl.demo.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompaniesList() {
        return companyRepository.findAll();
    }

    public Company getCompaniesByName(String name) {
        return companyRepository.findByName(name);
    }

//    public List<Employee> getCompanyEmployeesByName(String companyName) {
//        for(Company company:companieslist){
//            if(company.getCompanyName().equals(companyName)){
//                return company.getEmployeesList();
//            }
//        }
//        return null;
//    }
//
//    public ArrayList<Company> getCompaniesByPage(int page, int pageSize) {
//        ArrayList<Company> dispacth = new ArrayList<>();
//        int start = (page-1)*pageSize;
//        int end = (start + pageSize) > companieslist.size() ? companieslist.size() : (start+pageSize);
//        for(int i=start;i<end;i++){
//            dispacth.add(companieslist.get(i));
//        }
//        return dispacth;
//    }
//
    public Company postCompany(Company company) {
        return companyRepository.save(company);
    }

//    public Company updateCompanyByName(Company company,String name) {
//        companyRepository.findByName(name);
//        companyRepository.save(company);
//    }

    public Boolean deleteCompanyByName(String companyName) {
        if(companyRepository.existsByName(companyName)) {
            int result = companyRepository.deleteCompanyByName(companyName);
            return result != 0;
        }
        return false;
    }
}
