package com.shivank.springBoot.Learn.repository;

import com.shivank.springBoot.Learn.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

   public List<Department> getByDepartmentName(String departmentName);

   public List<Department> getByDepartmentAddress(String departmentAddress);

   public List<Department> getByDepartmentCode(String departmentCode);

}
