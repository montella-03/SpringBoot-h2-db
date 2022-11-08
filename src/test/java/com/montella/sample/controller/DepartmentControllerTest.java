package com.montella.sample.controller;

import com.montella.sample.entity.Department;
import com.montella.sample.error.DepartmentException;
import com.montella.sample.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)

class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        department= Department.builder()
                .departmentName("COMPUTER")
                .departmentCode("234")
                .departmentAddress("PO BOX 56")
                .departmentId(2L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
         Department inputDepartment= Department.builder()
                .departmentName("COMPUTER")
                .departmentCode("1-44 NAIROBI")
                .departmentAddress("PO BOX 56")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON).content("" +
                        "{\n" +
                        "\t\"departmentName\":\"COMPUTER\",\n" +
                        "\t\"departmentAddress\":\"1-44 NAIROBI\",\n" +
                        "\t\"departmentCode\":\"PO BOX 56\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName") .value(department.getDepartmentName()));

    }
}