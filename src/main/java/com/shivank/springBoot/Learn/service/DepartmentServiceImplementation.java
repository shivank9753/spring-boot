package com.shivank.springBoot.Learn.service;


import com.shivank.springBoot.Learn.Exceptions.DepartmentNotFoundException;
import com.shivank.springBoot.Learn.entity.Department;
import com.shivank.springBoot.Learn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> saveDepartment(List<Department> department) {
       return  departmentRepository.saveAll(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
      Optional<Department> department= departmentRepository.findById(departmentId);
      if(!department.isPresent()){
          throw new DepartmentNotFoundException("Department Not Present");
      }
      return department.get();
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Deleted Successfully";
    }

    @Override
    public String updateDepartment(Long departmentId,Department department) {
        Optional<Department> present= departmentRepository.findById(departmentId);

        if(present==null){
            return "Record Not Found";
        }
        Department existing = present.get();

        if(department.getDepartmentName()!=null && existing.getDepartmentName()!=department.getDepartmentName()){
            existing.setDepartmentName(department.getDepartmentName());
        }

        if(department.getDepartmentAddress()!=null && existing.getDepartmentAddress()!=department.getDepartmentAddress()){
            existing.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(department.getDepartmentCode()!=null && existing.getDepartmentCode()!=department.getDepartmentCode()){
            existing.setDepartmentCode(department.getDepartmentCode());
        }
        departmentRepository.save(existing);
        return "Updated Successfully";
    }

    @Override
    public List<Department> getByDepartmentName(String departmentName) {
        return departmentRepository.getByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getByDepartmentAddress(String departmentAddress) {
        return departmentRepository.getByDepartmentAddress(departmentAddress);
    }

    @Override
    public List<Department> getByDepartmentCode(String departmentCode) {
        return departmentRepository.getByDepartmentCode(departmentCode);
    }

    @Override
    public List<Department> getByMultiParams(Department target) {
        List<Department> dataBase= departmentRepository.findAll();
        List<Department>  ans= new ArrayList<Department>();


        for(int i=0;i<dataBase.size();i++){
              int check1=1,check2=1,check3=1;

            if(target.getDepartmentName()!=null && !target.getDepartmentName().equals(dataBase.get(i).getDepartmentName())){
                check1=0;
            }
            if(target.getDepartmentAddress()!=null && !target.getDepartmentAddress().equals(dataBase.get(i).getDepartmentAddress())){
                check2=0;
            }
            if(target.getDepartmentCode()!=null && !target.getDepartmentCode().equals(dataBase.get(i).getDepartmentCode())){
                check3=0;
            }

            if(check1*check2*check3==1){
                ans.add(dataBase.get(i));
            }
        }
        return  ans;

    }

}
