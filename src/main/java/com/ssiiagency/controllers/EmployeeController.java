package com.ssiiagency.controllers;

import com.ssiiagency.DAO.EmployeDaoImpl;
import com.ssiiagency.entities.Address;
import com.ssiiagency.entities.Employe;
import com.ssiiagency.entities.Role;
import com.ssiiagency.services.AddressServiceImpl;
import com.ssiiagency.services.EmployeServiceImpl;
import com.ssiiagency.services.ServiceInt;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private ServiceInt employeService;
    private ServiceInt addressService;
    private Address address;
    private Employe employe;
    private Role role;

    @Autowired
    public EmployeeController(@Qualifier("employeServiceImpl") ServiceInt employeService, @Qualifier("addressServiceImpl") ServiceInt addressService) {
        this.employeService = employeService;
        this.addressService = addressService;
    }
    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }
    @Autowired
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    @Autowired
    public void setRole(Role role) {
        this.role = role;
    }

    @GetMapping("")
    public String all(Model model){
        model.addAttribute("employees",employeService.getAll());
        return "employee/all";
    }

    @GetMapping("/add")
    public ModelAndView add(Model model){
        model.addAttribute("addresses",addressService.getAll());
        System.out.println(model.getAttribute("addresses"));
        return  new ModelAndView("employee/add");
    }


    @PostMapping("/add")
    public ModelAndView store(HttpServletRequest request,Model model){
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String addressId = request.getParameter("address");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postal_code");
        String entryDate = request.getParameter("entry_date");
        System.out.println("Post address id"+ addressId);
        if(firstName == null || lastName == null || email == null || password == null || entryDate == null || ( addressId == null && (country == null &&  city == null && street == null && postalCode == null) )){
            model.addAttribute("err","please fill all required fields!");
            return new ModelAndView("employee/add");
        }
        if(addressId == null){
            try {
                address.setPostalCode(Integer.parseInt(postalCode));
                address.setStreet(street);
                address.setCountry(country);
                address.setCity(city);
                address = (Address) addressService.add(address);
                System.out.println("Address created: "+address);
            }catch (HibernateException e){
                System.out.println("Can't add address: "+e.getMessage());
                model.addAttribute("err","Can't add address: "+e.getMessage());
                return new ModelAndView("employee/add");
            }
        }else {
            try {
                System.out.println("Address id found: "+addressId);
                address = (Address) addressService.find(Long.parseLong(addressId));
                System.out.println("Address selected: "+address);
            }catch (HibernateException e){
                System.out.println("Can't get Address: "+e.getMessage());
                model.addAttribute("err","Can't get Address: "+e.getMessage());
                return new ModelAndView("employee/add");
            }
        }
        try {
            employe.setFirstName(firstName);
            employe.setLastName(lastName);
            employe.setEmail(email);
            employe.setPassword(password);
            employe.setAddress(address);
            employe.setEntryDate(Date.valueOf(entryDate));
            employe.setGoneOut(false);
            employe = (Employe) employeService.add(employe);
            System.out.println("New employee created: "+employe);
        }catch (HibernateException e){
            System.out.println("Can't add employee: "+e.getMessage());
            model.addAttribute("err","Can't add employee: "+e.getMessage());
            return new ModelAndView("employee/add");

        }
        return new ModelAndView("redirect:/employee");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id, Model model){
        long employeeId = Long.parseLong(id);
        try{
            employeService.delete(employeeId);
        }catch (HibernateException e){
            System.out.println("Can't delete empliyee!");
        }
        return new ModelAndView("redirect:/employee");
    }
    @GetMapping("/update/{id}")
    public ModelAndView edit(@PathVariable("id") String id,Model model){
        long employeId = Long.parseLong(id);
        try{
            employe = (Employe) employeService.find(employeId);
            List<Address> addresses =  addressService.getAll();
            System.out.println(employe);
            model.addAttribute("employee",employe);
            model.addAttribute("addresses",addresses);
        }catch (HibernateException e){
            System.out.println("Can't get employee!");
        }
        return new ModelAndView("employee/edit");
    }
    @PostMapping("/update")
    public ModelAndView update(HttpServletRequest request,Model model){
        Long employeId = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String addressId = request.getParameter("address");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postal_code");
        String entryDate = request.getParameter("entry_date");
        if(firstName == null || lastName == null || email == null || password == null || entryDate == null || ( addressId == null && (country == null &&  city == null && street == null && postalCode == null) )){
            model.addAttribute("err","please fill all required fields!");
            System.out.println("data not good");
            return new ModelAndView("employee/add");
        }
        if(addressId == null){
            try {
                address.setPostalCode(Integer.parseInt(postalCode));
                address.setStreet(street);
                address.setCountry(country);
                address.setCity(city);
                address = (Address) addressService.add(address);
                System.out.println("Address created: "+address);
            }catch (HibernateException e){
                System.out.println("Can't add address: "+e.getMessage());
                model.addAttribute("err","Can't add address: "+e.getMessage());
                return new ModelAndView("employee/add");
            }
        }else {
            try {
                address = (Address) addressService.find(Long.parseLong(addressId));
                System.out.println("Address selected: "+address);
            }catch (HibernateException e){
                System.out.println("Can't get Address: "+e.getMessage());
                model.addAttribute("err","Can't get Address: "+e.getMessage());
                return new ModelAndView("employee/add");
            }
        }
        try {
            employe.setIdUser(employeId);
            employe.setFirstName(firstName);
            employe.setLastName(lastName);
            employe.setEmail(email);
            employe.setPassword(password);
            employe.setAddress(address);
            employe.setEntryDate(Date.valueOf(entryDate));
            employe.setGoneOut(false);
            employe = (Employe) employeService.update(employe);
            System.out.println("New employee created: "+employe);
        }catch (HibernateException e){
            System.out.println("Can't add employee: "+e.getMessage());
            model.addAttribute("err","Can't add employee: "+e.getMessage());
            return new ModelAndView("employee/add");

        }
        return new ModelAndView("redirect:/employee");
    }

    @GetMapping("gone-out/{id}")
    public ModelAndView setGoneOut(@PathVariable("id") String id,Model model){
        long meployeeId = Long.parseLong(id);
        try{
            ((EmployeServiceImpl)employeService).setAsGone(meployeeId);
        }catch (HibernateException e){
            System.out.println("can't set employee as gone!");
        }
        return new ModelAndView("redirect:/employee");
    }

    @GetMapping("working/{id}")
    public ModelAndView setAsWokring(@PathVariable("id") long id,Model model){
//        long employeeId = Long.parseLong(id);
        try{
            ((EmployeServiceImpl)employeService).setAsWokring(id);
            return new ModelAndView("redirect:/employee");
        }catch (HibernateException e){
            System.out.println("can't set employee as wokring!");
        }
        return null;
    }
}
