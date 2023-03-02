package com.finalproject.urproject.controller;

import com.finalproject.urproject.entity.Department;
import com.finalproject.urproject.entity.Leave;
import com.finalproject.urproject.repository.DepartmentRepository;
import com.finalproject.urproject.repository.LeaveRepository;
import com.finalproject.urproject.service.DepartmentService;
import com.finalproject.urproject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/leave")
public class LeaveController {

        @Autowired
        private LeaveService leaveService;
        @Autowired
        private LeaveRepository repository;

        @GetMapping("/add_leave")
        public String addEmployeeLeave(Model model) {
            model.addAttribute("leave", new Leave());
            return "new_leave";
        }
        @PostMapping("/save_leave")
        public String saveEmployeeLeave(Leave leave) {
            leaveService.saveLeave(leave);
            return "leaves";
        }

        @GetMapping("/edit/{id}")
        public String editEmployeeLeave(@PathVariable(name = "id") Long id, Model model) {

            Leave leave = repository.findById(id).get();
            model.addAttribute("leave", leave);
            return "new_leave";
        }

        @GetMapping("/delete/{id}")
        public String deleteEmployeeLeave(@PathVariable(name = "id") Long id, Model model) {
            leaveService.delete(id);
            return "redirect:/leaves";
        }
}
