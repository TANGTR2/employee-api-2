package com.oocl.demo.entities;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Company {
   public Company(){ }

   private String name;
   private int number;
   ArrayList<Employee> employeesList;

   public Company(String name,int number,ArrayList<Employee> employeesList){
      this.name = name;
      this.number = number;
      this.employeesList = employeesList;
   }

   public Company(String name, int number) {
      this.name = name;
      this.number = number;
   }

   public String getName() { return name; }
   public void setName(String name) { this.name = name; }

   public int getNumber() { return number; }
   public void setNumber(int number) { this.number = number; }

   public ArrayList<Employee> getEmployeesList() { return employeesList; }
   public void setEmployeesList(ArrayList<Employee> employeesList) { this.employeesList = employeesList; }
}
