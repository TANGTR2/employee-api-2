package com.oocl.demo.entities;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Company {
   public Company(){ }

   private String companyName;
   private int employeesNumber;
   ArrayList<Employee> employeesList;

   public Company(String companyName,int employeesNumber,ArrayList<Employee> employeesList){
      this.companyName = companyName;
      this.employeesNumber = employeesNumber;
      this.employeesList = employeesList;
   }

   public String getCompanyName() { return companyName; }
   public void setCompanyName(String companyName) { this.companyName = companyName; }

   public int getEmployeesNumber() { return employeesNumber; }
   public void setEmployeesNumber(int employeesNumber) { this.employeesNumber = employeesNumber; }

   public ArrayList<Employee> getEmployeesList() { return employeesList; }
   public void setEmployeesList(ArrayList<Employee> employeesList) { this.employeesList = employeesList; }
}
