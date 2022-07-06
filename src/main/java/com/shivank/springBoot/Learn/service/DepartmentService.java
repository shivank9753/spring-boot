package com.shivank.springBoot.Learn.service;

import com.shivank.springBoot.Learn.Exceptions.DepartmentNotFoundException;
import com.shivank.springBoot.Learn.entity.Department;

import java.util.List;

public interface DepartmentService {
   public List<Department> saveDepartment(List<Department> department);

   public List<Department> getAllDepartments();

   public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

   public String deleteDepartment(Long departmentId);

   public String updateDepartment(Long departmentId,Department department);

   public List<Department> getByDepartmentName(String departmentName);

   public List<Department> getByDepartmentAddress(String departmentAddress);

   public List<Department> getByDepartmentCode(String departmentCode);

   public List<Department> getByMultiParams(Department target);
}
