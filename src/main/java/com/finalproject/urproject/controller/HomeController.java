package com.finalproject.urproject.controller;

import com.finalproject.urproject.entity.Department;
import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.entity.Leave;
import com.finalproject.urproject.repository.EmployeeRepository;
import com.finalproject.urproject.service.DepartmentService;
import com.finalproject.urproject.service.EmployeeService;
import com.finalproject.urproject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private  EmployeeService employeeService;
    @Autowired
    private  EmployeeRepository repository;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private  LeaveService leaveService;
    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("gender",gender);
        return "register";
    }
    @PostMapping("/save")
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);
        return "register";
    }
    @RequestMapping(path = {"/dashboard"})
    public String listAllEmployee(Model model) {
        List<Employee> listEmployee = employeeService.findAllEmployee();
        model.addAttribute("employeeList", listEmployee);
        return "admindashboard";
    }
    @RequestMapping(path = {"/departments"})
    public String listAllDepartment(Model model) {
        List<Department> listEmployee = departmentService.findAllDepartment();
        model.addAttribute("departmentList", listEmployee);
        return "departments";
    }
    @RequestMapping(path = {"/leaves"})
    public String listAllLeaves(Model model) {
        List<Leave> leaveList = leaveService.findAllLeave();
        model.addAttribute("leaveList", leaveList);
        return "leaves";
    }
    @RequestMapping(path = {"/search"})
    public String searchEmployee(Model model, @Param("keyword") String keyword) {
        List<Employee> employeeList = employeeService.listAll(keyword);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("keyword", keyword);
        return "admindashboard";
    }
    @GetMapping("/employee/edit/{id}")
    public String editEnployee(@PathVariable(name = "id") Long id, Model model) {

        Employee employee = repository.findById(id).get();
        model.addAttribute("employee", employee);
        return "profile";
    }

    @GetMapping("employee/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id, Model model) {
        employeeService.delete(id);
        return "redirect:/admindashboard";
    }
    @GetMapping("/profile")
    public String userProfile() {
        return "profile";
    }
     static  List<String> gender = null;
    static  {
        gender.add("Male");
        gender.add("Female");
    }
}
