package com.shivank.springBoot.Learn.service;

import com.shivank.springBoot.Learn.entity.Department;
import com.shivank.springBoot.Learn.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        List<Department> departments = new ArrayList<>();
        Department department= Department.builder()
                .departmentName("Software")
                .departmentAddress("Sector 18 ,Gurgaon")
                .departmentCode("B0273254")
                .build();
        departments.add(department);
        department =Department.builder()
                .departmentName("Software")
                .departmentAddress("Sector 18 ,Gurgaon")
                .departmentCode("A1JGTYPA")
                .build();
        departments.add(department);
        Mockito.when(departmentRepository.getByDepartmentName("Software")).thenReturn(departments);
    }
    @Test
    @DisplayName("Get Data Based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
       String departmentName="Software";
        List<Department> found= departmentService.getByDepartmentName(departmentName);

        for(int i=0;i<found.size();i++){
            assertEquals(departmentName,found.get(i).getDepartmentName());
        }
    }
}