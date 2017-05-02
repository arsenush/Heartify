package com.heartify.controller;

import com.heartify.model.Doctor;
import com.heartify.model.Location;
import com.heartify.model.Patient;
import com.heartify.model.Prescription;
import com.heartify.model.pk.LocationPK;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
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
        Location location = new Location();
        location.setLocationPK(new LocationPK(3,3));

        Patient patient = new Patient();
        patient.setFirstName("Ars");
        patient.setSurname("Nikita");
        patient.setId(3);
        patient.setLocation(location);
        patient.setDiagnosis("Baniak");

        Prescription prescription = new Prescription();
        prescription.setAppointedDate(new Date());
        prescription.setPatient(patient);
        prescription.setDescription("klizma");

        List<Prescription> prescriptions = new ArrayList<>();
//        prescriptions.add(prescription);

//        model.addAttribute("operations", prescriptions);
        model.addAttribute("user", new Doctor());
        return "doctor/index";
    }
}
