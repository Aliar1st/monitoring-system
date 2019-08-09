package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.CardioMedInfoService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final SecurityService securityService;
    private final PatientService patientService;
    private final CardioMedInfoService cardioMedInfoService;
    private final EducationService educationService;

    @GetMapping
    public String index(Model model) {
        model
                .addAttribute(securityService.getPatientModel())
                .addAttribute(cardioMedInfoService.getByPatientId(1L))
                .addAttribute(educationService.getAll());
        return "patient/index";
    }

    @GetMapping("/{depId}")
    public String depIndex(@PathVariable Integer depId, Model model) {
        model
                .addAttribute("medicalInfo", patientService.getMedicalInfo(depId));
        return "";
    }
}
