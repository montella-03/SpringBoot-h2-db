package com.montella.sample.controller;

import com.montella.sample.error.DepartmentException;
import com.montella.sample.entity.Department;
import com.montella.sample.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger logger = LoggerFactory.getLogger(Department.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("inside the department controller");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("inside fetch list method");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
      departmentService.deleteDepartmentById(departmentId);
        return "deleted successful";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);

    }
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        return departmentService.getDepartmentByName(name);
    }
}
