package com.oocl.demo.model;

import org.springframework.stereotype.Service;

@Service
public class Company {
   public Company(){ }

   private String companyName;
   private int employeesNumber;
   private Employee employees;
}
