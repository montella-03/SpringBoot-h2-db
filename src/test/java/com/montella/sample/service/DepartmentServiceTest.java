package com.montella.sample.service;

import com.montella.sample.entity.Department;
import com.montella.sample.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
   @ Autowired
    private DepartmentService departmentService;

   @MockBean
   private DepartmentRepo repo;


    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("AI")
                        .departmentCode("2345RU")
                        .departmentAddress("PO BOX 50")
                        .build();

        Mockito.when(repo.findByDepartmentNameIgnoreCase("AI"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("DepartmentName test")
    public void  whenValidDepartment_then_departmentShouldBeFound(){
        String departmentName="AI";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }

}