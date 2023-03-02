package com.finalproject.urproject.controller;

import com.finalproject.urproject.entity.Department;
import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.repository.EmployeeRepository;
import com.finalproject.urproject.service.DepartmentService;
import com.finalproject.urproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/add_dep")
    public String addDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "new_dep";
    }
    @PostMapping("/save_dep")
    public String saveDepartment(Department department) {
        departmentService.save(department);
        return "departments";
    }
    @RequestMapping(path = {"/departments"})
    public String listAllDepartment(Model model) {
        List<Department> departmentList = departmentService.findAllDepartment();
        model.addAttribute("departmentList", departmentList);
        return "departments";
    }
    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable(name = "id") Long id, Model model) {

        Department department = repository.findById(id).get();
        model.addAttribute("department", department);
        return "new_dep";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable(name = "id") Long id, Model model) {
        departmentService.delete(id);
        return "redirect:/departments";
    }
}
