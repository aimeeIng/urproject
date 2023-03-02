package com.finalproject.urproject.service;

import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    public List<Employee> findAllEmployee(){
        return repo.findAll();
    }
    public void save(Employee employee){
        repo.save(employee);
    }
    public Employee get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public List<Employee> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
}
