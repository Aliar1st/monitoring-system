package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.AdminPatientService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static loc.aliar.monitoringsystem.domain.Department.ID_DEPARTMENTS;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final EducationService educationService;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        model
                .addAttribute("patient", securityService.getPatient())
                .addAttribute("educations", educationService.getAll());
        return "";
    }

    @GetMapping("/{depId}")
    public String depIndex(@PathVariable Integer depId, Model model) {
        model
                .addAttribute("medicalInfo", patientService.getMedicalInfo(depId));
        return "";
    }
}
