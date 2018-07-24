package com.oocl.demo.service;

import com.oocl.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    public ArrayList<Employee> list = new ArrayList<>();
    {
        Employee employee1 = new Employee(4,"alibaba1",20,"male",6000);
        Employee employee2 = new Employee(11,"tengxun2",19,"female",7000);
        list.add(employee1);
        list.add(employee2);
    }
    public ArrayList<Employee> getEmployeesList() {
        return list;
    }

    public Employee getEmployeeById(int id) {
        for(Employee employee:list){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeeBygender() {
        ArrayList<Employee> filterList = new ArrayList<>();
        for(Employee employee:list){
            if(employee.getGender().equals("male")){
                filterList.add(employee);
            }
        }
        return filterList;
    }

    public ArrayList<Employee> postEmployee(Employee employee) {
        Employee newEmployee = new Employee(employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getGender(),
                employee.getSalary());
        list.add(newEmployee);
        return list;
    }
}
