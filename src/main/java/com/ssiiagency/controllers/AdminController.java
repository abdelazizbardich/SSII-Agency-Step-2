package com.ssiiagency.controllers;

import com.ssiiagency.services.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminServiceImpl adminService;

    @Autowired
    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;

    }


    @GetMapping("/login")
    public String getLogin(){
        return "admin/login";
    }


    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request,Model model){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email == null || password == null){
            System.out.println("null");
            model.addAttribute("err","Empty Email or password!");
            return new ModelAndView("admin/login");
        }
        if(adminService.login(email,password)){
            System.out.println("ok");
            HttpSession session = request.getSession();
            session.setAttribute("user", adminService.findByEmail(email));
            System.out.println("session User: "+session.getAttribute("user"));
            return new ModelAndView("redirect:/employee/");
        }else {
            System.out.println("no");
            model.addAttribute("err","Wrong email or password");
            return new ModelAndView("admin/login");
        }
    }
}
