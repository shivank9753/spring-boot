package com.shivank.springBoot.Learn.controller;

import com.shivank.springBoot.Learn.Exceptions.DepartmentNotFoundException;
import com.shivank.springBoot.Learn.entity.Department;
import com.shivank.springBoot.Learn.service.DepartmentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImplementation departmentServiceImplementation;

    @PostMapping
    public List<Department> saveDepartment(@Valid  @RequestBody List<Department> department){

       return   departmentServiceImplementation.saveDepartment(department);
    }
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentServiceImplementation.getAllDepartments();
    }
    @GetMapping(path = "/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return  departmentServiceImplementation.getDepartmentById(departmentId);
    }
    @GetMapping("/departmentName")
    public List<Department> getByDepartmentName(@RequestParam("departmentName") String departmentName){
        return  departmentServiceImplementation.getByDepartmentName(departmentName);
    }
    @GetMapping("/departmentAddress")
    public List<Department> getByDepartmentAddress(@RequestParam("departmentAddress") String departmentAddress){
        return departmentServiceImplementation.getByDepartmentAddress(departmentAddress);
    }
    @GetMapping("/departmentCode")
    public  List<Department> getByDepartmentCode(@RequestParam("departmentCode") String departmentCode){
        return  departmentServiceImplementation.getByDepartmentCode(departmentCode);
    }
    @GetMapping("/params")
    public List<Department> getByMultiParams(@Valid @RequestBody @NotBlank Department target){
        return  departmentServiceImplementation.getByMultiParams(target);
    }
    @PutMapping(path = "/{id}")
    public String updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
              return departmentServiceImplementation.updateDepartment(departmentId,department);

    }
    @DeleteMapping(path = "/{id}")
    public  String deleteDepartment(@PathVariable("id")  Long departmentId){
       return departmentServiceImplementation.deleteDepartment(departmentId);
    }
}
