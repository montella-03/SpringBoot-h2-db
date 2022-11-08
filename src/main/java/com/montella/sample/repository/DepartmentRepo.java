package com.montella.sample.repository;

import com.montella.sample.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String department);
    public Department findByDepartmentNameIgnoreCase(String department);

}
