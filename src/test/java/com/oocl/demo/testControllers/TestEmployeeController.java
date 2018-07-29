package com.oocl.demo.testControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.demo.controllers.EmployeeController;
import com.oocl.demo.entities.Employee;
import com.oocl.demo.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class TestEmployeeController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getEmployee_ReturnEmployeeDetails() throws Exception{
        //given
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1",20,"male",6000);
        employees.add(employee);
        given(employeeService.getEmployeesList()).willReturn(employees);
        //when //then
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
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
        given(employeeService.getEmployeeById(id)).willReturn(employee);
        //when //then
        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("alibaba"))
                .andExpect(jsonPath("age").value(20))
                .andExpect(jsonPath("gender").value("male"))
                .andExpect(jsonPath("salary").value(6000));
    }

    @Test
    public void getEmployeeBygender_ReturnEmployees() throws Exception{
        //given
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("alibaba1",20,"male",6000);
        employees.add(employee1);
        given(employeeService.getEmployeeBygender()).willReturn(employees);
        //when //then
        mockMvc.perform(get("/employees/male"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("alibaba1"))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(6000));
    }

    @Test
    public void should_return_employee_when_post_to_add_employee() throws Exception{
        //given
        Employee employee = new Employee("alibaba",20,"male",6000);
        when(employeeService.AddEmployee(employee)).thenReturn(employee);
        //when
        ResultActions result = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)));
        //then
        result.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void should_return_employee_when_put_employee() throws Exception{
        //given
        Employee employee = new Employee(1L,"baidu",20,"male",6000);
        when(employeeService.updateEmployeeById(anyLong(), any(Employee.class))).thenReturn(employee);
        //when
        ResultActions result = mockMvc.perform(put("/employees/{1}", employee.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(employee))
                );

        //then
        result.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void should_delete_employee_when_delete_employee_by_id() throws Exception {
        //given
        Employee employee = new Employee(1L,"baidu",20,"male",6000);
        when(employeeService.deleteEmployeeById(employee.getId())).thenReturn(true);
        //when
        ResultActions result = mockMvc.perform(delete("/employees/{1}", employee.getId()));
        //then
        result.andExpect(status().isOk())
                .andDo(print());
    }
}


