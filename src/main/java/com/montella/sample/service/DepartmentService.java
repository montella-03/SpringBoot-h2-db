package com.montella.sample.service;

import com.montella.sample.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

   List<Department> fetchDepartmentList();

  Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);
}