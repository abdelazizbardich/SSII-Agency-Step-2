package com.ssiiagency.controllers;

import com.ssiiagency.DAO.DAOInt;
import com.ssiiagency.entities.Address;
import com.ssiiagency.entities.Employe;
import com.ssiiagency.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private DAOInt employeDao;
    private DAOInt addressDao;
    @Autowired
    public EmployeeController(@Qualifier("employeDaoImpl") DAOInt employeDao, @Qualifier("addressDaoImpl") DAOInt addressDao) {
        this.employeDao = employeDao;
        this.addressDao = addressDao;
    }

    @GetMapping("")
    public String all(Model model){
        model.addAttribute("employees",employeDao.getAll());
        return "employee/all";
    }

    @GetMapping("/add")
    public String add(){
        return "employee/add";
    }


    @PostMapping("/add")
    public ModelAndView store(HttpServletRequest request,Model model){
//        String firstName = request.getParameter("first_name");
//        String lastName = request.getParameter("last_name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
        String addressId = request.getParameter("address");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postal_code");
//        String entryDate = request.getParameter("entry_date");
//        if(firstName == null || lastName == null || email == null || password == null || ( addressId == null && (country == null &&  city == null && street == null && postalCode == null) )){
//            model.addAttribute("err","please fill all required fields!");
//            return new ModelAndView("employee/add");
//        }
//        try {
        long newAddressId;
        if(addressId == null){
            newAddressId = ((Address) addressDao.add(new Address(street,city,country,Integer.parseInt(postalCode)))).getIdAddress();
        }else {
            newAddressId = new Long(addressId);
        }
//            employeDao.add(new Employe(firstName,lastName,email,password,false));
            return new ModelAndView("redirect:/employee/");
//        }catch (Exception e){
//            model.addAttribute("err","Error unexpected!");
//            return new ModelAndView("employee/add");
//        }
    }

    @GetMapping("/delete")
    public String delete(){
        return  "employee/all";
    }
    @GetMapping("/update")
    public String edit(){
        return "employee/edit";
    }
    @PostMapping("/update")
    public String update(){
        return "employee/all";
    }
}
