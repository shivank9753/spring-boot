package com.shivank.springBoot.Learn.repository;

import com.shivank.springBoot.Learn.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department =Department.builder()
                .departmentName("GET")
                .departmentAddress("Karjat ,Gujarat")
                .departmentCode("IO6492L")
                .build();
        testEntityManager.persist(department);
    }
    @Test
    public void findById_thenReturnDepartment(){
     Long DepartmentId=1L;
      Department department= departmentRepository.findById(DepartmentId).get();
      assertEquals(department.getDepartmentName(),"GET");
    }
}