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
//
//    public ArrayList<Employee> updateEmployeeById(Employee employee) {
//        for (Employee e : list) {
//            if (e.getId() == employee.getId()) {
//                e.setName(employee.getName());
//                e.setAge(employee.getAge());
//                e.setGender(employee.getGender());
//                e.setSalary(employee.getSalary());
//            }
//        }
//        return list;
//    }
//
//    public ArrayList<Employee> deleteEmployeeById(int id) {
//        for (Employee e : list) {
//            if (e.getId() == id) {
//                list.remove(e);
//            }
//        }
//        return list;
//    }
//
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
