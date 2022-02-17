package com.ssiiagency.controllers;

import com.ssiiagency.services.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private AdminServiceImpl adminService;

    @Autowired
    public HomeController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("admin",adminService.getAll());
        return "welcome";
    }
}
