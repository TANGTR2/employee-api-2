package com.oocl.demo.testControllers;

import com.oocl.demo.controllers.EmployeeController;
import com.oocl.demo.entities.Employee;
import com.oocl.demo.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class TestEmployeeController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getEmployee_ReturnEmployeeDetails() throws Exception{
        //given
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1",20,"male",6000);
        employees.add(employee);
        //when
        given(employeeService.getEmployeesList()).willReturn(employees);
        //then
        mockMvc.perform(get("/employees")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("alibaba1"))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(6000));
    }

    @Test
    public void getEmployeeById_ReturnEmployee() throws Exception{
        //given
        long id = 1L;
        Employee employee = new Employee("alibaba",20,"male",6000);
        //when
        given(employeeService.getEmployeeById(id)).willReturn(employee);
        //then
        mockMvc.perform(get("/employees/1")).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("alibaba"))
                .andExpect(jsonPath("age").value(20))
                .andExpect(jsonPath("gender").value("male"))
                .andExpect(jsonPath("salary").value(6000));
    }

//    @Test
//    public void getEmployeeBygender_ReturnEmployees() throws Exception{
//        ArrayList<Employee> employees = new ArrayList<>();
//        Employee employee1 = new Employee("alibaba1",20,"male",6000);
//        Employee employee2 = new Employee("tengxun2",19,"female",7000);
//        employees.add(employee1);employees.add(employee2);
//        given(employeeService.getEmployeeBygender()).willReturn(employees);
//
//        mockMvc.perform(get("/employees/male")).andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(4))
//                .andExpect(jsonPath("$[0].name").value("alibaba1"))
//                .andExpect(jsonPath("$[0].age").value(20))
//                .andExpect(jsonPath("$[0].gender").value("male"))
//                .andExpect(jsonPath("$[0].salary").value(6000));
//    }
}


