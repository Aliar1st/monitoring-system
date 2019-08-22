package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final SecurityService securityService;
    private final PatientService patientService;
    private final EducationService educationService;

    @GetMapping
    public String index(HttpSession session, Model model) {
        Integer depId = (Integer) session.getAttribute(Constants.DEP_ATTR);
        if (!patientService.isRegisteredInDepartment(depId)) {
            return "";
        }

        model
                .addAttribute(securityService.getPatientModel())
                .addAttribute(patientService.getMedicalInfo(depId))
                .addAttribute(educationService.getAll());
        return "";
    }
}
