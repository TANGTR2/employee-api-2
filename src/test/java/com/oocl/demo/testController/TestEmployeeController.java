package com.oocl.demo.testController;

import com.oocl.demo.controller.EmployeeController;
import com.oocl.demo.model.Employee;
import com.oocl.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

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
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(4,"alibaba1",20,"male",6000);
        employees.add(employee);
        given(employeeService.getEmployeesList()).willReturn(employees);

        mockMvc.perform(get("/employees")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].name").value("alibaba1"))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(6000));
    }

    @Test
    public void getEmployeeById_ReturnEmployee() throws Exception{
        Employee employee = new Employee(4,"alibaba",20,"male",6000);
        given(employeeService.getEmployeeById(employee.getId())).willReturn(employee);

        mockMvc.perform(get("/employees/4")).andExpect(status().isOk())
                .andExpect(jsonPath("id").value(4))
                .andExpect(jsonPath("name").value("alibaba"))
                .andExpect(jsonPath("age").value(20))
                .andExpect(jsonPath("gender").value("male"))
                .andExpect(jsonPath("salary").value(6000));
    }

    @Test
    public void getEmployeeBygender_ReturnEmployees() throws Exception{
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(4,"alibaba1",20,"male",6000);
        Employee employee2 = new Employee(11,"tengxun2",19,"female",7000);
        employees.add(employee1);employees.add(employee2);
        given(employeeService.getEmployeeBygender()).willReturn(employees);

        mockMvc.perform(get("/employees/male")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].name").value("alibaba1"))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(6000));
    }
}


