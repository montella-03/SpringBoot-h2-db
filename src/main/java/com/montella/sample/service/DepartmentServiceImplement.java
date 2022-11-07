package com.montella.sample.service;

import com.montella.sample.entity.Department;
import com.montella.sample.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImplement implements DepartmentService{
    @Autowired
    private DepartmentRepo repo;
    @Override
    public Department saveDepartment(Department department) {
        return repo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return repo.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return repo.findById(departmentId).get();
    }

    @Override
    public void  deleteDepartmentById(Long departmentId) {
         repo.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department db = repo.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            db.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            db.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            db.setDepartmentAddress(department.getDepartmentAddress());
        }
        else {
            System.out.println("department not found");
        }
        return repo.save(db);
    }
}
