package com.heartify.controller;

import com.heartify.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/alarm")
    public String notFoundError(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor = new Doctor();
        doctor.setSpecialization("Surgeon");
        doctor.setId(5);
        doctor.setAddress("Kozlaniuka");
        doctor.setAvatar("http://res.cloudinary.com/arsenush/image/upload/default.jpg");
        doctor.setFirstName("Arsen");
        doctor.setSurname("Niki");
        doctors.add(doctor);
        model.addAttribute("allPersonal", doctors);
        return "admin/personal";
    }
}
