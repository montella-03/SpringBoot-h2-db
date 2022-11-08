package com.montella.sample.repository;

import com.montella.sample.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepoTest {
    @Autowired
    private DepartmentRepo repo;
    @Autowired
    private EntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("MATH")
                .departmentAddress("PO BOX 30")
                .departmentCode("234K")
                .build();
        entityManager.persist(department);
    }
    @Test
    @DisplayName("Display by ID Test")
    public  void findById_then_returnDepartment(){
        Department department=repo.findById(1l).get();
        assertEquals(department.getDepartmentName(),"MATH");
    }
}