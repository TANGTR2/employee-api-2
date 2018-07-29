package com.oocl.demo.services;

import com.oocl.demo.entities.Employee;
import com.oocl.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    //    public ArrayList<Employee> list = new ArrayList<>();
//    {
//        Employee employee1 = new Employee("alibaba1",20,"male",6000);
//        Employee employee2 = new Employee("tengxun2",19,"female",7000);
//        list.add(employee1);
//        list.add(employee2);
//    }
    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesList() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getEmployeeBygender() {
        return employeeRepository.findByGender("male");
    }

    public Employee AddEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeById(Long id,Employee employee) {
        if(employeeRepository.existsById(id))
            return employeeRepository.save(employee);
        return null;
    }

    public Boolean deleteEmployeeById(Long id) {
        if(employeeRepository.existsById(id)) {
            int result = employeeRepository.deleteEmployeeById(id);
            return result != 0;
        }
        return false;
    }

//    public ArrayList<Employee> getEmployeesByPage(int page, int pageSize) {
//        ArrayList<Employee> dispacth = new ArrayList<>();
//        int start = (page - 1) * pageSize;
//        int end = (start + pageSize) > list.size() ? list.size() : (start + pageSize);
//        for (int i = start; i < end; i++) {
//            dispacth.add(list.get(i));
//        }
//        return dispacth;
//    }
}
