package com.finalproject.urproject.service;

import com.finalproject.urproject.entity.Department;
import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
        @Autowired
        private DepartmentRepository repo;
        public List<Department> findAllDepartment(){
            return repo.findAll();
        }
        public void save(Department department){
            repo.save(department);
        }
        public Department get(Long id){
            return repo.findById(id).get();
        }
        public void delete(Long id){
            repo.deleteById(id);
        }

    }
