package com.oocl.demo.testControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.demo.controllers.CompanyController;
import com.oocl.demo.entities.Company;
import com.oocl.demo.entities.Employee;
import com.oocl.demo.services.CompanyService;
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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class TestCompanyController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getCompanies_ReturnCompaniesList() throws Exception{
        //given
        Company company1 = new Company("alibaba",2);
        Company company2 = new Company("tengxun",1);
        List<Company> companies = Arrays.asList(company1, company2);
        given(companyService.getCompaniesList()).willReturn(companies);
        //when //then
        mockMvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("alibaba"))
                .andExpect(jsonPath("$[0].number").value(2))
                .andExpect(jsonPath("$[1].name").value("tengxun"))
                .andExpect(jsonPath("$[1].number").value(1));
    }

    @Test
    public void should_get_company_when_call_findByName() throws Exception{
        //given
        String name = "alibaba";
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1",20,"male",6000);
        employees.add(employee);
        Company company = new Company("alibaba",2,employees);
        given(companyService.getCompaniesByName(name)).willReturn(company);
        //when //then
        mockMvc.perform(get("/companies/alibaba"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("alibaba"))
                .andExpect(jsonPath("number").value(2));
    }

    @Test
    public void should_return_company_when_post_to_add_company() throws Exception{
        //given
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1",20,"male",6000);
        employees.add(employee);
        Company company = new Company("alibaba",2,employees);
        when(companyService.postCompany(company)).thenReturn(company);
        //when
        ResultActions result = mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(company)));
        //then
        result.andExpect(status().isOk())
                .andDo(print());
    }
}
