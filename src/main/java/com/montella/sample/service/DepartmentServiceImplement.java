package com.montella.sample.service;

import com.montella.sample.error.DepartmentException;
import com.montella.sample.entity.Department;
import com.montella.sample.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Department fetchDepartmentById(Long departmentId) throws DepartmentException {
        Optional<Department> optional=repo.findById(departmentId);
        if(!optional.isPresent())
            throw new DepartmentException("department is unavailable");
        return optional.get();
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

    @Override
    public Department getDepartmentByName(String name) {
        return repo.findByDepartmentNameIgnoreCase(name);
        // when the method isn't available , we define it from repo.
    }
}
